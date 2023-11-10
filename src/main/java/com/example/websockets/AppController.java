package com.example.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public Message handleMessage(Message message) {
        if (!message.getMessage().isEmpty()) {
            message.setMessage("Возвращаю обратно: " + message.getMessage());
            return message;
        } else {
            return new Message("Пустое сообщение");
        }
    }
}
