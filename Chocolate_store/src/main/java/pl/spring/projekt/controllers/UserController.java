package pl.spring.projekt.controllers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.spring.projekt.domain.User;
import pl.spring.projekt.domain.UserRole;
import pl.spring.projekt.service.UserService;
import pl.spring.projekt.validators.UserValidator;

@Controller
@SessionAttributes
public class UserController {

	@Autowired
	UserService userService;
	
	
	
	UserValidator userValidator = new UserValidator();
	
	@RequestMapping("/users")
	public String listUsers(Map<String, Object> map, HttpServletRequest request) {
	   
		int userId = ServletRequestUtils.getIntParameter(request, "userId" , -1);
		   
		if (userId > 0)
		{	
			User user = userService.getUser(userId);
			map.put("user", user);
		}
	    else
		   map.put("user", new User());   
	       
		map.put("userRoleList",userService.listUserRole());
		map.put("userList", userService.listUser());

	    return "user";
	}
	
   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
   public String addContact(@ModelAttribute("user") User user, BindingResult result, 
		   HttpServletRequest request, Map<String, Object> map,RedirectAttributes redirect)throws Exception {
        
	   userValidator.validate(user, result);
	   
	   if (result.getErrorCount()==0)
	   {
		   if (user.getId()==0)
		   {
			   UserRole role = new UserRole();
			   role.setId(1);
			   role.setRole("ROLE_USER");
			   Set<UserRole> u = new HashSet<UserRole>(0);
			   user.setEnabled(true);
			   u.add(role);
			   user.setUserRole(u);
			   userService.addUser(user);
		   }
	       else
	       {
	    	   	    	   
			   userService.editUser(user);
			   return "redirect:profile.html";
	       }
		   
/*	       System.out.println("First Name: " + user.getFirstname() +
                   " Last Name: " + user.getLastname() + " Tel.: " + 
	    		   user.getTelephone() + " Email: " + user.getEmail());
*/
		   redirect.addFlashAttribute("flash", "success");
	       return "redirect:users.html";
	   }
       
	   map.put("userRoleList",userService.listUserRole());
	  
	   map.put("userList", userService.listUser());
	   return "user";
   }
   
   @RequestMapping("/deleteUser/{userId}")
   public String deleteUser(@PathVariable("userId") Integer userId) {
       userService.removeUser(userId);

       return "redirect:/users.html";
   }
//   @RequestMapping("/users")
//   public ModelAndView showContacts() {
//        
//       return new ModelAndView("user", "command", new User());
//   }
   
   @RequestMapping("/userRole")
   public ModelAndView showUserRole() {
     
    return new ModelAndView("userRole", "userRole", new UserRole());
   }
   
   @RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
   public String addUserRole(@ModelAttribute("userRole") UserRole userRole, BindingResult result, 
		   						HttpServletRequest request, Map<String, Object> map) {
        
			   userService.addUserRole(userRole);
		   
	       return "redirect:users.html";
	   }
}

