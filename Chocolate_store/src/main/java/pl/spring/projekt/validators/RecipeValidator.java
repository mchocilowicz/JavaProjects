package pl.spring.projekt.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.spring.projekt.domain.Recipe;


public class RecipeValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return Recipe.class.isAssignableFrom(clazz);
	}

	private String name = "^[A-Z]'?[- a-zA-Z]( [a-zA-Z])*$";
	
	public void validate(Recipe recipe, Errors errors) {
		
		  ValidationUtils.rejectIfEmpty(errors,"name", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"components", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"description", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"image", "error.field.required");
		  
		
	}


	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
