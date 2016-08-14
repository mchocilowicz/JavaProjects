package pl.spring.projekt.dao;

import java.util.List;

import pl.spring.projekt.domain.Recipe;

public interface RecipeDAO {
	
	public void addRecipe(Recipe recipe);
	public List<Recipe> listRecipe();
	public void removeRecipe (int id);
	public Recipe getRecipe(int id);
	public void editRecipe(Recipe recipe);
	public Recipe findByUsername(String username);

}
