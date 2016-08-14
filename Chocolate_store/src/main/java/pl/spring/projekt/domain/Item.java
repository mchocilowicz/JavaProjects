package pl.spring.projekt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
    private String name;
    private String orderBy;
    private Integer quantity;
    private double price;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	

		
	

}
