package com.example.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.example.model.Message;

@WebService
@SOAPBinding(style = Style.RPC)
public interface RpcChat {

	@WebMethod
	Object[] getMessages();
	
	@WebMethod
	Message[] getMessages2();
	
	@WebMethod
	void addMessage(String message);

	@WebMethod
	void clearMessages();
	
}
