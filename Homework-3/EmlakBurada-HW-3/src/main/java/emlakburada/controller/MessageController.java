package main.java.emlakburada.controller;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Message;
import emlakburada.model.User;
import emlakburada.service.MessageService;
import emlakburada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public ResponseEntity<Message> saveUser(@RequestBody MessageRequest request) {
        messageService.saveMessage(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageResponse>> findAll() {
        return new ResponseEntity<>(messageService.findAll(),HttpStatus.CREATED);

    }

    @GetMapping(value = "/messages/{messageId}")
    public ResponseEntity<MessageResponse> findByMessageId(@PathVariable(required = false) int messageId) {
        return new ResponseEntity<>(messageService.findByMessageId(messageId), HttpStatus.OK);
    }
}
