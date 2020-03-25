package com.Kiheyunkim.SpringChatbot.ChatMessage.Service;

import com.Kiheyunkim.SpringChatbot.ChatMessage.Model.ChatAddMessage;
import com.Kiheyunkim.SpringChatbot.ChatMessage.Model.ChatMessage;

public interface ChatMessageService {
	public ChatMessage getAnswer(ChatMessage message);
	public ChatMessage addAnswer(ChatAddMessage addMessage);
}
