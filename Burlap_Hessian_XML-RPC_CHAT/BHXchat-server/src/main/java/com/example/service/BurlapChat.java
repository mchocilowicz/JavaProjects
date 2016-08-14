package com.example.service;

import java.util.List;

import com.example.model.Message;

public interface BurlapChat {
	
	void addMessage(String message);

	void clearMessages();

	List<Message> getMessages();
}
