package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.ChatMessage;

import java.util.ArrayList;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {
	
	public static ArrayList<ChatMessage> chatList = new ArrayList<ChatMessage>();   
    
    @MessageMapping("{route_id}/chat.sendMessage")
    @SendTo("/topic/{route_id}")
    public ChatMessage sendMessageTopic(@Payload ChatMessage chatMessage)
    {
    	chatList.add(chatMessage);
    	return chatMessage ;
    }
    
    @MessageMapping("{route_id}/chat.addUser")
    @SendTo("/topic/{route_id}")
    public ChatMessage addUserTopic(@Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
    	chatList.add(chatMessage);
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
    }
}