package books

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BookController {

    static allowedMethods = [ update: "PUT", delete: "DELETE"]
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index(Integer max) {
        params.sort= 'id'
        params.order= 'desc'
        
        def res
        if(params.long('categoryId')==null){
            params.max = 10  
            res =  Book.createCriteria().list(params){
                eq ("isDeleted" , false)
            }
        }else{        
            res = Book.createCriteria().list(params){
                and{
                    eq ("category.id" , params.long('categoryId'))
                    eq ("isDeleted",  false)
                }
            }
        }
        respond res, model:[bookCount: res.totalCount]

        respond Category.list(params), model:[categoryCount: Category.count()]
    }
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show(Book book) {
        respond book
        respond Category.list(params), model:[categoryCount: Category.count()]
    }
    
    @Secured(['ROLE_ADMIN']) 
    def create() {
        respond new Book(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN']) 
    def save(Book book) {
     
        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'create'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }
    
    
    @Secured(['ROLE_ADMIN']) 
    def edit(Book book) {
        respond book
    }
    
    @Secured(['ROLE_ADMIN']) 
    def editPhoto(Book book) {
        respond book
    }
    
    @Transactional
    @Secured(['ROLE_ADMIN']) 
    def delete(Book book) {

        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        
        book.isDeleted = true
        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Secured(['ROLE_USER','ROLE_ADMIN']) 
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    @Secured(['ROLE_USER']) 
    def addToCard(Book book){
        if (session["order"] == null ){
            session["order"] = []
        }
        for (orderItem in session["order"]) {
            if (orderItem.book.id == book.id){
                orderItem.amount = orderItem.amount+1
                redirect controller: 'card', params: params
                return;
            }
        }
        session["order"].add(new OrderItem(book:book, amount:1)) 
   

        redirect controller: 'card', params: params
    }
    
    private static final okcontents = ['image/png', 'image/jpeg', 'image/gif']
    
    @Transactional
    @Secured(['ROLE_ADMIN']) 
    def update2(Book book) {
        def f = request.getFile('image')
        
        // List of OK mime-types
        if (f!=null && f.bytes.length != 0) {
            if(!okcontents.contains(f.getContentType())){
                flash.message = "Dozwolone formaty pliku: ${okcontents}"
                render(view:'edit', model:[book:book])
                return
            } else{
                book.image = f.bytes
                book.imageType = f.contentType
            }
        }


        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'edit'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def displayImage() {
        def book = Book.get(params.id)
        if (!book || !book.image ) {
            response.sendError(404)
            return
        }
        response.contentType = book.imageType
        response.contentLength = book.image.size()
        OutputStream out = response.outputStream
        out.write(book.image)
        out.close()
    }
    
    
}
