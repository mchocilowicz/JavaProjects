package com.example;

import javax.xml.ws.Endpoint;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.RpcChatImpl;

@SpringBootApplication
public class BhXchatApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BhXchatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endpoint.publish("http://localhost:8181/xmlrpc", new RpcChatImpl());
	}
}
