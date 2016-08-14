package books

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class UserController {
    def authenticateService
    def springSecurityService

    def list = { 
        def user = authenticateService.principal() 
        def username = user?.getUsername()
    } 
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    @Secured(['ROLE_ADMIN']) 
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]
    }
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def show(User user) {

        if(springSecurityService.currentUser.authorities.contains(Role.findByAuthority('ROLE_ADMIN')) || springSecurityService.currentUser == user){
            respond user
        }
        else{
            response.sendError(404)
            return
        }
    }
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def create() {
        respond new User(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def save(User user) {
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'create'
            return
        }

        user.save flush:true
        UserRole.create user, Role.findByAuthority('ROLE_USER')
      
        request.withFormat {
            form multipartForm {
                flash.message =  message(code: 'user.created')
                redirect controller: 'book', action: 'index', params: params

            }
            '*' { respond user, [status: CREATED] }
        }
    }
    
    @Secured(['ROLE_USER','ROLE_ADMIN']) 
    def edit(User user) {
        if(springSecurityService.currentUser.authorities.contains(Role.findByAuthority('ROLE_ADMIN')) || springSecurityService.currentUser == user){
            respond user
        }
        else{
            response.sendError(404)
            return
        }
  
    }

    @Secured(['ROLE_USER','ROLE_ADMIN']) 
    def editPhoto(User user) {
        respond user
    }
    
    private static final okcontents = ['image/png', 'image/jpeg', 'image/gif']

    @Transactional
    @Secured(['ROLE_ADMIN','ROLE_USER']) 
    def update2(User user) {
        
        def f = request.getFile('image')
        
        // List of OK mime-types
        if (f!=null && f.bytes.length != 0) {
            if(!okcontents.contains(f.getContentType())){
                flash.message = "Dozwolone formaty pliku: ${okcontents}"
                render(view:'edit', model:[book:book])
                return
            } else{
                user.image = f.bytes
            }
        }
        
        
        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors, view:'edit'
            return
        }

        user.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN']) 
    def delete(User user) {

        if (user == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        
        user.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'deleted.object')
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    @Secured(['ROLE_ADMIN','ROLE_USER']) 
    def displayImage() {
        def user = User.get(params.id)
        if (!user || !user.image) {
            response.sendError(404)
            return
        }
        response.contentType = user.imageType
        response.contentLength = user.image.size()
        OutputStream out = response.outputStream
        out.write(user.image)
        out.close()
    }
}
