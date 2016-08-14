package pl.spring.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.projekt.service.PurchaseService;
import pl.spring.projekt.service.UserService;



@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PurchaseService purchaseService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
 
		return model;
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("userList", userService.listUser());
		model.setViewName("userList");
		
		return model;
		
	}
	
	@RequestMapping(value = "/purchasedItems", method = RequestMethod.GET)
	public ModelAndView purchasedItemsPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("purchased", purchaseService.findAllPurchases());
		model.setViewName("purchasedItems");
		
		return model;
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model;
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView accessDenied404() 
	{
 
		ModelAndView model = new ModelAndView();
		model.setViewName("404");
 
		return model; 
 
	}
	
}
