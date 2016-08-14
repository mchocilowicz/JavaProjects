package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.example.model.Message;

@WebService(endpointInterface = "com.example.service.RpcChat")
public class RpcChatImpl implements RpcChat {
	private List<Message> messageList = new ArrayList<Message>();

	@Override
	public Object[] getMessages() {
		return messageList.toArray();
	}

	@Override
	public void addMessage(String message) {
		messageList.add(new Message(message));
		System.out.println(messageList.size());
	}

	@Override
	public void clearMessages() {
		messageList.clear();
	}

	@Override
	public Message[] getMessages2() {
		Message[] array = new Message[messageList.size()];
		messageList.forEach(message->{
			array[messageList.indexOf(message)] = message;
		});
		return array;
	}

}
