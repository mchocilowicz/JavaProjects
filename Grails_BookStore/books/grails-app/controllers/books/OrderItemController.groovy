package books

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class OrderItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN']) 
    def show(OrderItem orderItem) {
        redirect action:"show", controller:'book', id: orderItem.book.id
    }

    
}
