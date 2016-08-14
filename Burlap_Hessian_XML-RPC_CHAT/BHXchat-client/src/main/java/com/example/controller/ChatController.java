package com.example.controller;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caucho.services.message.MessageServiceException;
import com.example.model.CustomUserDetails;
import com.example.model.Message;
import com.example.service.BurlapChat;
import com.example.service.HessianChat;
import com.example.service.RpcChat;

@Controller
@EnableAsync
@EnableScheduling
public class ChatController {
	@Autowired
	HessianChat hessianChat;
	@Autowired
	BurlapChat burlapChat;
	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	RpcChat rpcChat;
	private Date loginDate;
	
	public Date getUserLoginDate(){
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		loginDate = ((CustomUserDetails) user).getLoginDate();
		return loginDate;
	}
	@RequestMapping(value = "/hessian")
	public String hessianChat(Model model) throws MalformedURLException {
		List<Message> messages = hessianChat.getMessages();
		messages.removeIf(messageToRemove -> messageToRemove.getDate().before(getUserLoginDate()));
		model.addAttribute("messages", messages);
		return "hessianChat";
	}
	
	@RequestMapping(value = "/hessian", method = RequestMethod.POST)
	public String addHessianMessage(Model model, @RequestParam("message") String message)
			throws MalformedURLException, MessageServiceException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		hessianChat.addMessage(name + ": " + message);
		return "hessianChat";
	}
	
	@RequestMapping(value = "/hessian2")
	public @ResponseBody List<Message> hessianChat2(Model model) throws MalformedURLException {
		List<Message> messages = hessianChat.getMessages();
		messages.removeIf(messageToRemove -> messageToRemove.getDate().before(getUserLoginDate()));
		model.addAttribute("messages", messages);
		return messages;
	}

	@RequestMapping(value = "/burlap")
	public String BurlapChat(Model model) throws MalformedURLException {
		List<Message> messages = burlapChat.getMessages();
		messages.removeIf(messageToRemove -> messageToRemove.getDate().before(getUserLoginDate()));
		model.addAttribute("messages", messages);
		return "burlapChat";
	}
	
	@RequestMapping(value = "/burlap", method = RequestMethod.POST)
	public String addBurlapMessage(Model model, @RequestParam("message") String message) throws MalformedURLException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		burlapChat.addMessage(name + ": " + message);
		return "burlapChat";
	}
	
	@RequestMapping(value = "/burlap2")
	public @ResponseBody List<Message> BurlapChat2(Model model) throws MalformedURLException {
		List<Message> messages = burlapChat.getMessages();
		messages.removeIf(messageToRemove -> messageToRemove.getDate().before(getUserLoginDate()));
		model.addAttribute("messages", messages);
		return messages;
	}

	@RequestMapping(value = "/xmlrpc", method = RequestMethod.GET)
	public String xmlRpcChat(Model model) throws MalformedURLException {
		List<Object> messages = new ArrayList<Object>(Arrays.asList(rpcChat.getMessages()));
		messages.removeIf(messageToRemove ->{
			return ((Message)messageToRemove).getDate().before(getUserLoginDate());
			});
		model.addAttribute("messages", messages);
		return "xmlRpcChat";
	}

	@RequestMapping(value = "/xmlrpc", method = RequestMethod.POST)
	public String addXmlRpcMessage(Model model, @RequestParam("message") String message) throws MalformedURLException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		rpcChat.addMessage(name + ": " + message);
		return "xmlRpcChat";
	}

	@RequestMapping(value = "/xmlrpc2")
	public @ResponseBody List<Object> xmlRpcChat2(Model model) throws MalformedURLException {
		List<Object> messages = new ArrayList<Object>(Arrays.asList(rpcChat.getMessages()));
		messages.removeIf(messageToRemove ->{
			return ((Message)messageToRemove).getDate().before(getUserLoginDate());
			});
		model.addAttribute("messages", messages);
		return messages;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
}
