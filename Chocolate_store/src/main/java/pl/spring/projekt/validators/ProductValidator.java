package pl.spring.projekt.validators;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.spring.projekt.domain.Product;
import pl.spring.projekt.domain.Recipe;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private String name = "^[A-Z]'?[- a-zA-Z]( [a-zA-Z])*$";

	public void validate(Product product, Errors errors) {
		
		  ValidationUtils.rejectIfEmpty(errors,"name", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"description", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"price", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"photo", "error.field.required");
		  
		  if (errors.getErrorCount() == 0) 
		  	{
			  if (product.getPrice() > 100){
				  errors.rejectValue("price", "error.toHighPrice");
			  }
		  	}
		  
	}
	
}
