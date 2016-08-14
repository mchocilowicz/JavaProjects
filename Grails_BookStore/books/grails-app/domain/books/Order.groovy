package books

class Order {
    User user
    Date date
    List orderItems
    
    static int removeAll(User u) {
        u == null ? 0 : Order.where { user == u }.deleteAll()
    }
    
    static mapping = {
        table 'order_tab'
    }
    static hasMany = [
        orderItems : OrderItem 
    ]

    static constraints = {
        date defaultValue: "now()"
    }
 
    
}
