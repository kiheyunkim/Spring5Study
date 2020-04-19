package com.kiheyunkim.kim.common.socket;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
@Controller
public class WebSocketConfiguration implements WebSocketConfigurer{

	@Bean
	public ServletServerContainerFactoryBean configureWebSocketContainer() {
		ServletServerContainerFactoryBean factory = new ServletServerContainerFactoryBean();
		factory.setMaxBinaryMessageBufferSize(16384);
		factory.setMaxTextMessageBufferSize(16384);
		factory.setMaxSessionIdleTimeout(TimeUnit.MINUTES.convert(30, TimeUnit.MILLISECONDS));
		factory.setAsyncSendTimeout(TimeUnit.SECONDS.convert(5, TimeUnit.MILLISECONDS));

		return factory;
	}
	
	@Bean
	public EchoHandler echoHandler() {
		return new EchoHandler();
	}
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler(), "/echo");
	}
	
	
}
