package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.example.service.BurlapChat;
import com.example.service.HessianChat;

@Configuration
@ComponentScan
public class WebConfig {
	
	@Autowired
    private HessianChat hessianChat;
	@Autowired
	private BurlapChat burlapChat;
	
	
	@Bean(name="/HessianChat")
	public HessianServiceExporter hessianChatService(){
		HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessianChat);
        exporter.setServiceInterface(HessianChat.class);
        return exporter;
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean(name="/BurlapChat")
	public BurlapServiceExporter BurlapChatService(){
		BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(burlapChat);
        exporter.setServiceInterface(BurlapChat.class);
        return exporter;
	}
	
}
