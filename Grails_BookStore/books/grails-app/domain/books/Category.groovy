package books

class Category {
    String name

    def beforeDelete() {
        Book.withNewSession {
            def book = Book.findByCategory(this)
            book.each {
                it.category = null
                it.save(flush: true)
            } // flush is necessary
        }
    }
    String toString(){
        return "${name}" 
    }
    
    static constraints = {
        name blank: false, unique: true
    }
    
}
