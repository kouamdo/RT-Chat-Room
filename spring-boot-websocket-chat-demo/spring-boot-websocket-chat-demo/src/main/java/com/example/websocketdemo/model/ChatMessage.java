package com.example.websocketdemo.model;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String canal;
    
    public String[] SendTo ;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
}
