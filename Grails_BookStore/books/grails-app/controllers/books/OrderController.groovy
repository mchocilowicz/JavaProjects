package books

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class OrderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    @Secured(['ROLE_ADMIN']) 
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Order.list(params), model:[orderCount: Order.count()]
    }
    
    @Secured(['ROLE_ADMIN']) 
    def show(Order order) {
        respond order
    }
    
    @Secured(['ROLE_ADMIN']) 
    @Transactional
    def delete(Order order) {

        if (order == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        order.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'order.label', default: 'Order'), order.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
