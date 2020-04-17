package com.kiheyunkim.kim.common.socket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception{
		session.sendMessage(new TextMessage("CONNECTION ESTABLISHED"));
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) 
			throws Exception{
		String msg = message.getPayload();
		session.sendMessage(new TextMessage("RECEIVED: " + msg));
	}
}
