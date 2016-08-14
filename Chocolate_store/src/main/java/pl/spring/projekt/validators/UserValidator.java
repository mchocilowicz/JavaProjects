package pl.spring.projekt.validators;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.spring.projekt.domain.User;

public class UserValidator implements Validator
	{
		  
		  private static String loginRegex             = "[a-zA-Z]*";
		  private static String digitsRegex            = ".*\\p{Digit}.*";
		  private static String specialCharactersRegex = ".*[!£$#%^&*@?<>+_].*";
		  private static String number				   = "/^[0-9]{2}-[0-9]{3}$/";
		  EmailValidator emailValidator = EmailValidator.getInstance();
		  private static String adressRegex             = "[A-Za-z]*";
		
	  @Override
	  public boolean supports(Class clazz)
	  {
	    return User.class.isAssignableFrom(clazz);
	  }
	  @Override
	  public void validate(Object arg0, Errors arg1)
	  {
	    // TODO Auto-generated method stub
	  }
	  public void validate(User user, Errors errors)
	  {
		  ValidationUtils.rejectIfEmpty(errors,"firstname", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"lastname", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"telephone", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"city", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"country", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"zipCode", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"street", "error.field.required");
		  ValidationUtils.rejectIfEmpty(errors,"number", "error.field.required");
		  
		  
		  
		  if (errors.getErrorCount() == 0) 
		  	{
		   		if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false)
		   		{
		   			errors.rejectValue("email", "error.email.invalid");
		   		}
		   		if (StringUtils.hasText(user.getFirstname()) && emailValidator.isValid(user.getEmail()) == false)
		   		{
		   			errors.rejectValue("email", "error.email.invalid");
		   		}
		   		
		  	}
	  }

}
