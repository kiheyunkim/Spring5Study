package com.Kiheyunkim.SpringChatbot.ChatMessage.Model;

public class ChatAddMessage {
	private String question;
	private String answer;
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}
}
