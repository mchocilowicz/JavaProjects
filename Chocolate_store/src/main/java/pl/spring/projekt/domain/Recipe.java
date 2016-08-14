package pl.spring.projekt.domain;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="recipe")
public class Recipe {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private int id;
		
		@Column(name="name", nullable=false)
		private String name;
		@Column(name="components", nullable=false, length = 100000 )
		private String components;
		@Column(name="description", nullable=false,length = 100000 )
	    private String description;
		@Column(name="username", nullable=false)
	    private String username;
		@Column(name="date", nullable=false)
	    private String date;
		
		@Lob
		private byte[] image;
	    
	   

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getComponents() {
			return components;
		}

		public void setComponents(String components) {
			this.components = components;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Recipe [id=" + id + ", name=" + name + ", components=" + components + ", description=" + description
					+ ", username=" + username + ", date=" + date + "]";
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}
		
	    
	    
	    
	
}
