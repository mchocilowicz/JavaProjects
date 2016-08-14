package pl.spring.projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.projekt.dao.RecipeDAO;
import pl.spring.projekt.domain.Recipe;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeDAO recipeDAO;
	
	@Transactional
	public void addRecipe(Recipe recipe) {
		recipeDAO.addRecipe(recipe);
		
	}

	@Transactional
	public List<Recipe> listRecipe() {
		return recipeDAO.listRecipe();
	}

	@Transactional
	public void removeRecipe(int id) {
		recipeDAO.removeRecipe(id);
		
	}

	@Transactional
	public Recipe getRecipe(int id) {
		return recipeDAO.getRecipe(id);
	}

	@Transactional
	public void editRecipe(Recipe recipe) {
		recipeDAO.editRecipe(recipe);
		
	}

	
	

}
