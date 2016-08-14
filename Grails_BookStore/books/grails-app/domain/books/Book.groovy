package books

class Book {
    Integer id
    String title;
    String author;
    Integer year;
    Integer price;
    String description;
    Category category;
    byte[] image;
    String imageType;
    Boolean isDeleted = false;
  
    String toString(){
        return "${title} - ${author}" 
    }
    static mapping = {
        description sqlType:"text"
    }
    static constraints = {
        id blank: false, unique: true
        price scale: 2
        image(nullable:true, maxSize: 16384 *100 /* 16K *100 */)
        category nullable:true
        imageType(nullable:true)
        year min: 1900, max:2016
        description  widget: 'textarea'
    }
}
