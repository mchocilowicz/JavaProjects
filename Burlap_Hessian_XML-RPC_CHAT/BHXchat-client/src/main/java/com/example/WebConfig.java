package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.caucho.burlap.client.BurlapProxyFactory;
import com.caucho.hessian.client.HessianProxyFactory;
import com.example.service.BurlapChat;
import com.example.service.HessianChat;
import com.example.service.RpcChat;

@Configuration
@ComponentScan
public class WebConfig {

	@Bean(name = "hessianChat")
	public HessianChat hessianChat() throws MalformedURLException {
		String url = "http://localhost:8080/HessianChat";
		HessianProxyFactory factory = new HessianProxyFactory();
		HessianChat basic = (HessianChat) factory.create(HessianChat.class, url);
		return basic;
	}

	@Bean(name = "burlapChat")
	public BurlapChat burlapChat() throws MalformedURLException {
		String url = "http://localhost:8080/BurlapChat";
		BurlapProxyFactory factory = new BurlapProxyFactory();
		BurlapChat basic = (BurlapChat) factory.create(BurlapChat.class, url);
		return basic;
	}

	@Bean
	public RpcChat rpcChat() throws MalformedURLException {
		URL url = new URL("http://localhost:8181/xmlrpc?wsdl");
		QName qname = new QName("http://service.example.com/", "RpcChatImplService");
		Service service = Service.create(url, qname);
		RpcChat chat = service.getPort(RpcChat.class);
		return chat;

	}
}
