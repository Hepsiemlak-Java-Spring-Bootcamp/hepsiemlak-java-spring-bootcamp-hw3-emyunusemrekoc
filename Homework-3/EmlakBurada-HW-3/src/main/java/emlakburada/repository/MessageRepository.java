package main.java.emlakburada.repository;

import emlakburada.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private static List<Message> messages = new ArrayList<>();

    public Message saveMessage(Message message) {

        messages.add(message);
        System.out.println(message.toString());

        return message;
    }

    public List<Message> findAll() {

        return messages;
    }

    public Message findByMessageId(int messageId) {
        return messages.stream().filter(message -> message.getId() == messageId).findAny().orElse(new Message());
    }
}
