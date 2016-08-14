package pl.spring.projekt.controllers;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.spring.projekt.domain.Item;
import pl.spring.projekt.domain.Product;
import pl.spring.projekt.domain.Purchase;

import pl.spring.projekt.service.ItemService;
import pl.spring.projekt.service.ProductService;
import pl.spring.projekt.service.PurchaseService;

@Controller

public class CartController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PurchaseService purchaseService;
	
	
	

	
	@RequestMapping(value="/cartAdd/{productId}")
	public String addToCart(@PathVariable("productId") Integer productId){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String login = auth.getName();
		
		Product product = productService.getProduct(productId);
		Item item = itemService.find(product.getName());
		if(item != null){
			item.setQuantity(item.getQuantity() + 1);
			itemService.update(item);
			System.out.println("Zwiekszono o jedenj");
		}
		else{
			Item newItem = new Item();
			newItem.setName(product.getName());
			newItem.setOrderBy(login);
			newItem.setPrice(product.getPrice());
			newItem.setQuantity(1);
		    itemService.addItem(newItem);
		}
	  
		return "redirect:/shop.html";
		
	}
	
	@RequestMapping(value="/cart/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") Integer itemId){
		itemService.removeItem(itemId);
		
		return "redirect:/cart.html";
	}
	
	@RequestMapping(value="/cart/riseAmount/{itemId}")
	public String riseAmount(@PathVariable("itemId") Integer itemId){
	
		 Item i = itemService.find(itemId);
		 i.setQuantity(i.getQuantity() + 1);
		 itemService.update(i);
		
		 return "redirect:/cart.html";
	}
	
	@RequestMapping(value="/cart/lowerAmount/{itemId}")
	public String lowerAmount(@PathVariable("itemId") Integer itemId){
	
		 Item i = itemService.find(itemId);
		 i.setQuantity(i.getQuantity() - 1);
		 itemService.update(i);
		
		 return "redirect:/cart.html";
	}
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String showCart(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String login = auth.getName(); 
		List<Item> lista = itemService.listItem(login);
		
		model.addAttribute("cart", lista);
		model.addAttribute("totalCost", totalCost(lista));
		
		
		
		return "cart";
	}
	
	private double totalCost(List<Item> lista){
		double totalCost = 0;
		
		for(Item i : lista){
			totalCost += (i.getPrice() *i.getQuantity()) ;
		}
		
		return  Math.round(totalCost * 100.0) / 100.0;
		
	}
	
	@RequestMapping(value="/placeOrder")
	public String placeOrder(RedirectAttributes redirect){
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String login = auth.getName(); 
		List<Item> lista = itemService.listItem(login); 
		
		Date datte=new Date();
		  DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		  String date=dateFormat.format(datte);
		
		for(Item i : lista){
			Purchase purchase = new Purchase();
			purchase.setOrderBy(i.getOrderBy());
			purchase.setProduct(i.getName());
			purchase.setQuantity(i.getQuantity());
			purchase.setDate(date);
			purchaseService.add(purchase);
		}
		
		itemService.removeItems(login);
		
		redirect.addFlashAttribute("yCart", "success");
		return "redirect: cart";
	}
	

}
