package com.mattila.rabbitmq.controllers;

import com.mattila.rabbitmq.entities.Message;
import com.mattila.rabbitmq.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessagesController {

  private final MessageService messageService;

  @PostMapping("publish")
  ResponseEntity<Void> publishMessage(@RequestBody String message) {
    log.info("Sending message to the ActiveMQ: {}", message);
    messageService.publishMessage(message);
    return ResponseEntity.ok().build();
  }

  @GetMapping("messages")
  ResponseEntity<List<Message>> getMessages() {
    return ResponseEntity.ok(messageService.getMessages());
  }
}
