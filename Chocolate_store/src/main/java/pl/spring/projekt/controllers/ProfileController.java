package pl.spring.projekt.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import pl.spring.projekt.domain.User;
import pl.spring.projekt.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView userprofile() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("profile");
		 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String login = auth.getName(); 
	      User user = userService.findByLogin(login);
	      
	      model.addObject("user",user);
		
		return model;

	}
	
	@RequestMapping("/profile/image/{userId}")
	public void displayPhoto(@PathVariable("userId") Integer userId, HttpServletResponse response){
		User user = userService.getUser(userId);
		
		try{
		response.setContentType("image/jpg");
		response.setCharacterEncoding("UTF-8");
		OutputStream o = response.getOutputStream();
		if(user.getPhoto() != null){
			o.write(user.getPhoto());
			}
		
		o.flush();
		o.close();
		}catch(IOException e){}
	}

}
