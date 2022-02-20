package main.java.emlakburada.service;

import emlakburada.dto.MessageRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Message;
import emlakburada.model.User;
import emlakburada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private static int messageId = 0;

    public MessageResponse saveMessage(MessageRequest request) {
        Message savedMessage = messageRepository.saveMessage(convertToMessage(request));

        return convertToMessageResponse(savedMessage);
    }

    public List<MessageResponse> findAll() {

        List<MessageResponse> messageList = new ArrayList<>();
        for (Message message : messageRepository.findAll()) {
            messageList.add(convertToMessageResponse(message));
        }
        return messageList;

    }

    public MessageResponse findByMessageId(int messageId) {
        Message message = messageRepository.findByMessageId(messageId);
        return convertToMessageResponse(message);
    }

    private MessageResponse convertToMessageResponse(Message savedMessage) {
        MessageResponse response = new MessageResponse();
        response.setMessage((savedMessage.getMessage()));
        response.setTitle(savedMessage.getTitle());
        response.setId(savedMessage.getId());

        return response;
    }

    private Message convertToMessage(MessageRequest messageRequest) {
        Message message = new Message();
        messageId++;

        message.setId(messageId);
        message.setMessage(messageRequest.getMessage());
        message.setTitle(messageRequest.getTitle());

        return message;
    }

}
