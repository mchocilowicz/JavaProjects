package books

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String username
    String password
        
    String firstName
    String lastName
    String city
    String street;
    String zipCode;
    byte[] image;
    String imageType;

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    String toString(){
        return "${firstName} ${lastName}" 
    }
    
    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }
    def beforeDelete() {
        UserRole.removeAll(this)
        Order.withNewSession {
            def ord = Order.findByUser(this)
            ord.each { it.delete(flush: true) } // flush is necessary
        }
    }
    
    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        password blank: false, password: true
        username blank: false, unique: true, email: true
        image(nullable:true, maxSize: 16384 *100 /* 16K *100 */)
        imageType(nullable:true)
    }

    static mapping = {
        password column: '`password`'
    }
    
}
