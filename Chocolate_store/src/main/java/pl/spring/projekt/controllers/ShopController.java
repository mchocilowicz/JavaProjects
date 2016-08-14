package pl.spring.projekt.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.spring.projekt.domain.Product;
import pl.spring.projekt.service.ProductService;
import pl.spring.projekt.validators.ProductValidator;

@Controller

public class ShopController {
	
	@Autowired
	private ProductService productService;
	
	
	
	ProductValidator validator = new ProductValidator();

	@RequestMapping(value="/shop", method = RequestMethod.GET)
	public String productList(Model model,HttpServletRequest request) {
		
		
		int productId =  ServletRequestUtils.getIntParameter(request, "productId", -1);
		
		if(productId > 0){
			model.addAttribute("product", productService.getProduct(productId));
		}
		else{
			model.addAttribute("product",new Product());
			model.addAttribute("productList", productService.listProduct());
			
		}
	    
		
	    return "shop";
	}
	
		
	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	   public String addProduct(@ModelAttribute("product") Product product , BindingResult result, 
			   HttpServletRequest request, Map<String, Object> map,RedirectAttributes redirect,@RequestParam("photo")MultipartFile file) throws Exception {
	        
		validator.validate(product, result); 
		
		
		   
		   if (result.getErrorCount()==0)
		   {
			   if (product.getId()==0)
			   {
				   if(file.getBytes()!= null){
					   product.setPhoto(file.getBytes());
				   }
				   
				   productService.addProduct(product);
				   System.out.println("DOdany");
			   }
			   else{
				   if(file.getBytes()!= null){
					   product.setPhoto(file.getBytes());
				   }
				   ;
				   productService.editProduct(product);
			   }
		      
			   return "redirect:shop.html";
	
			
		   }
	       
		   
		  
		   
		   return "shop";
	   }
	
	@RequestMapping("/product/image/{productId}")
	public void displayImage(@PathVariable("productId") int productId, HttpServletResponse response){
		Product product = productService.getProduct(productId);
		
		try{
		response.setContentType("image/jpg");
		response.setCharacterEncoding("UTF-8");
		OutputStream o = response.getOutputStream();
		if(product.getPhoto() != null){
			o.write(product.getPhoto());
			}
		
		o.flush();
		o.close();
		}catch(IOException e){}
	}

	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId){
		productService.removeProduct(productId);
		return "redirect:/shop.html";
	}
	
	
	
}
