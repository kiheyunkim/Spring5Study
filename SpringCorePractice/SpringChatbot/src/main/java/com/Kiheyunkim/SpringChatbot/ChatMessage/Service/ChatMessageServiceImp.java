package com.Kiheyunkim.SpringChatbot.ChatMessage.Service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.Kiheyunkim.SpringChatbot.ChatMessage.Model.ChatAddMessage;
import com.Kiheyunkim.SpringChatbot.ChatMessage.Model.ChatMessage;

@Service
public class ChatMessageServiceImp implements ChatMessageService {

	private Map<String,String> answerTree = new TreeMap<String, String>();
	
	@Override
	public ChatMessage getAnswer(ChatMessage message) {
		if(message == null) {
			//Exception
		}
		
		String answer = answerTree.get(message.getMessage());
		ChatMessage retMsg = new ChatMessage();
		
		if(answer != null) {
			retMsg.setMessage(answer);
		}else {
			retMsg.setMessage("해당 질문에 대한 답이 없습니다.");
		}
				
		return retMsg;
	}

	@Override
	public ChatMessage addAnswer(ChatAddMessage addMessage) {
		if(addMessage == null) {
			//Exception
		}
		
		String retMsg = answerTree.put(addMessage.getQuestion(),addMessage.getAnswer());
		if(retMsg == null) {
			
		} 
		else {
			
		}
		return null;
	}

}
