package pl.spring.projekt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
    private String name;
    
    @Column(name="description", nullable=false,length = 100000 )
    private String description;
    
    private double price;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Lob
    private byte [] photo;

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	public double getPrice() {
        return this.price;
    }

	public void setPrice(double price) {
        this.price = price;
    }



	
	public String toString() {
        return this.getName();
    }

	
	public byte [] getPhoto() {
		return photo;
	}

	public void setPhoto(byte [] photo) {
		this.photo = photo;
	}

		
	

		
}
