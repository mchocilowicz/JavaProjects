package pl.spring.projekt.service;

import java.util.List;

import pl.spring.projekt.domain.Recipe;

public interface RecipeService {
	
	public void addRecipe(Recipe recipe);
	public List<Recipe> listRecipe();
	public void removeRecipe (int id);
	public Recipe getRecipe(int id);
	public void editRecipe(Recipe recipe);
	

}
