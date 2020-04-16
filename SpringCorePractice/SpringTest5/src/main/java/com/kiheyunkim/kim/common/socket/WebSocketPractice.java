package com.kiheyunkim.kim.common.socket;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketPractice {
	@Bean
	public ServletServerContainerFactoryBean configureWebSocketContainer() {
		ServletServerContainerFactoryBean factory = new ServletServerContainerFactoryBean();
		factory.setMaxBinaryMessageBufferSize(16384);
		factory.setMaxTextMessageBufferSize(16384);
		factory.setMaxSessionIdleTimeout(TimeUnit.MINUTES.convert(30, TimeUnit.MILLISECONDS));
		factory.setAsyncSendTimeout(TimeUnit.SECONDS.convert(5, TimeUnit.MILLISECONDS));

		return factory;
	}
}
