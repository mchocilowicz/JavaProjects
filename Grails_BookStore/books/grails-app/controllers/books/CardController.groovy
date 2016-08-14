package books

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class CardController {
    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_USER']) 
    def index() {
        respond sum : getPrice()
    }

    @Secured(['ROLE_USER']) 
    def deleteItem(Book book){
        def order =  session["order"]
        for (item in session["order"]) {
            if (item.book.id == book.id){
                session["order"].remove(item)
                break
            }
        }
        redirect action: 'index', params: params
    }
    
    @Secured(['ROLE_USER']) 
    @Transactional
    def order(){
        def order = new Order();
      
        order.user = springSecurityService.getCurrentUser()
        println order.user.id
        order.date = new Date()
        for(orderItem in session["order"]){
            order.addToOrderItems(orderItem)
        }

        order.save(flush: true, failOnError: true)    
        session["order"] = null
    }
    
    def getPrice(){
        def sum = 0
        for (item in session["order"]) {
            sum = sum + (item.book.price * item.amount)
        }
        return sum
    }
   
}
