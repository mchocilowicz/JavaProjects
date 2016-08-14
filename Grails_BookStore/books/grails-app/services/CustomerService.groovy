
class CustomerService {
    def createCustomer(books.User customer){
        customer.save
        def userRole = books.Role.findByAuthority('ROLE_USER')
        books.UserRole.create customer, userRole
    }
}

