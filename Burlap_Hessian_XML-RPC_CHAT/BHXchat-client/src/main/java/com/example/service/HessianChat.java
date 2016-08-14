package com.example.service;

import java.util.List;
import java.util.Properties;

import com.caucho.services.message.MessageServiceException;
import com.example.model.Message;

public interface HessianChat {
	
	void addMessage(String message) throws MessageServiceException;

	void clearMessages();

	List<Message> getMessages();
	
	Properties getUsers();

	void addUser(String username);

	void terminateUser(String username);
}
