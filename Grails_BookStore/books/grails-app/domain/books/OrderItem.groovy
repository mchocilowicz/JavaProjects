package books

class OrderItem {
    Book book
    Order order
    Integer amount

    String toString(){
        return "${book} - ${amount} szt" 
    }
    
    static constraints = {
    }
    static belongsTo =
    [
        order:Order
    ]
}
