package pl.spring.projekt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.spring.projekt.domain.Recipe;

@Repository
public class RecipeDAOImpl implements RecipeDAO{

	@Autowired
    SessionFactory sessionFactory;
	
	public void addRecipe(Recipe recipe) {
		sessionFactory.getCurrentSession().save(recipe);
	}
		 
	public List<Recipe> listRecipe() {
		 return sessionFactory.getCurrentSession().createQuery("from Recipe order by date desc").list();
	}
		 
	public void removeRecipe(int id) {
		 Recipe recipe = (Recipe) sessionFactory.getCurrentSession().load(Recipe.class, id);
		 if (null != recipe) {
			 sessionFactory.getCurrentSession().delete(recipe);
		 }
	}
	
	public Recipe getRecipe(int id) {
		 return (Recipe)sessionFactory.getCurrentSession().get(Recipe.class, id);
	}
		    
	public void editRecipe(Recipe recipe) {
		 sessionFactory.getCurrentSession().update(recipe);
	}
			
		  
	@SuppressWarnings("unchecked")
	public Recipe findByUsername(String username)
	{
		List<Recipe> recipe = new ArrayList<Recipe>();
			  
		recipe = sessionFactory.getCurrentSession()
							   .createQuery("from Recipe where username=?")
							   .setParameter(0, username)
					           .list();

		if (recipe.size() > 0) {
			return recipe.get(0);
		} else {
			return null;
		}
	}

		
		  	
}
