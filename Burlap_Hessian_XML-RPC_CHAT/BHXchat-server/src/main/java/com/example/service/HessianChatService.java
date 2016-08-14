package com.example.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.example.model.Message;

@Service("hessianChat")
public class HessianChatService implements HessianChat {
	private List<Message> message = new ArrayList<Message>();
	private Properties users = new Properties();
	public HessianChatService() {
	}

	@Override
	public void addMessage(String textMessage) throws IOException {
		message.add(new Message(textMessage));
		System.out.println("New Message");
	}

	@Override
	public List<Message> getMessages() {
		return message;
	}

	@Override
	public Properties getUsers() {
		return users;
	}

	@Override
	public void terminateUser(String username) {
		users.remove(username);
	}

	@Override
	public void addUser(String username) {
		users.put(username, ",ROLE_USER,enabled");
	}

	@Override
	public void clearMessages() {
		message.clear();
	}
}
