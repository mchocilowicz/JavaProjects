package pl.spring.projekt.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.spring.projekt.domain.Recipe;
import pl.spring.projekt.service.RecipeService;
import pl.spring.projekt.validators.RecipeValidator;

@Controller
@SessionAttributes
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	RecipeValidator validator = new RecipeValidator();


	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
	public String recipeList(Map<String,Object> map,HttpServletRequest request) {
		
		int recipeId = ServletRequestUtils.getIntParameter(request, "recipeId", -1);
		
		if(recipeId > 0){
			map.put("recipe", recipeService.getRecipe(recipeId));
		}
		else{
			map.put("recipe",new Recipe());
			map.put("recipeList", recipeService.listRecipe());
		}
	    

	    return "recipe";
	}
	
	@RequestMapping("/recipe/image/{recipeId}")
	public void displayImage(@PathVariable("recipeId") Integer recipeId, HttpServletResponse response){
		Recipe recipe = recipeService.getRecipe(recipeId);
		
		try{
		response.setContentType("image/jpg");
		response.setCharacterEncoding("UTF-8");
		OutputStream o = response.getOutputStream();
		if(recipe.getImage() != null){
			o.write(recipe.getImage());
			}
		
		o.flush();
		o.close();
		}catch(IOException e){}
	}
	
	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	   public String addRecipe(@ModelAttribute("recipe") Recipe recipe , BindingResult result, 
			   HttpServletRequest request, Map<String, Object> map,RedirectAttributes redirect, @RequestParam("image")MultipartFile file) throws Exception {
	        
		validator.validate(recipe, result);   
		
			Date datte=new Date();
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String date=dateFormat.format(datte);
		
		   
		   if (result.getErrorCount()==0)
		   {
			   if (recipe.getId()==0)
			   {
				   if(file.getBytes()!= null){
					   recipe.setImage(file.getBytes());
				   }
				   recipe.setDate(date);
				   recipeService.addRecipe(recipe);
				   System.out.println("DOdany");
			   }
			   else{
				   if(file.getBytes()!= null){
					   recipe.setImage(file.getBytes());
				   }
				   recipe.setDate(date);
				   recipeService.editRecipe(recipe);
			   }
		      
			   
	
			   redirect.addFlashAttribute("flash", "success");
		       return "redirect:recipe.html";
		   }
	       
		   
		  
		   
		   return "recipe";
	   }
	
	@RequestMapping("/deleteRecipe/{recipeId}")
	public String deleteRecipe(@PathVariable("recipeId")Integer recipeId){
		recipeService.removeRecipe(recipeId);
		return "redirect:/recipe.html";
	}
	
}
