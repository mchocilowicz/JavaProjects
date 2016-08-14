package com.example.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.model.Message;

@Service("burlapChat")
public class BurlapChatService implements BurlapChat {
	private List<Message> message = new ArrayList<Message>();
	public BurlapChatService(){
	}
	
	@Override
	public void addMessage(String textMessage) {
		message.add(new Message(textMessage));
		System.out.println("Added");
	}
	
	@Override
	public List<Message> getMessages() {
		return message;
	}
	
	@Override
	public void clearMessages() {
		message.clear();
	}
}
