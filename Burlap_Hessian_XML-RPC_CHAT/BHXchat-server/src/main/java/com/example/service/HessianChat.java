package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.caucho.services.message.MessageServiceException;
import com.example.model.Message;

public interface HessianChat {
	
	void addMessage(String message) throws MessageServiceException, IOException;

	void clearMessages();

	List<Message> getMessages();
	
	Properties getUsers();

	void terminateUser(String username);

	void addUser(String username);
}
