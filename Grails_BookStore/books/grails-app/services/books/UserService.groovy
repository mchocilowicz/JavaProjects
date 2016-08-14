package books

import grails.transaction.Transactional

@Transactional
class UserService {

    def deleteUser(User user) {
        UserRole.removeAll(user)
        user.delete flush:true
    }
}
