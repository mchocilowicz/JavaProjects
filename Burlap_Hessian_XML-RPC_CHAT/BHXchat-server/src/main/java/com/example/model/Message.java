package com.example.model;

import java.io.Serializable;
import java.util.Date;
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2995296510114439412L;
	private String textMessage;
	private Date date;
	
	public Message() {
	}

	public Message(String message) {
		super();
		this.textMessage = message;
		this.date = new Date();
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
