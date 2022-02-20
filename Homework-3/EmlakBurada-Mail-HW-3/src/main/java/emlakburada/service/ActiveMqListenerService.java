package main.java.emlakburada.service;

import emlakburada.dto.EmailMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActiveMqListenerService {

    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "emlakburada.queue")
    public void receiveMessage(String message) {

        EmailMessage emailMessage = new  EmailMessage(message);
        log.info(message);
        emailService.send(emailMessage.toString());
    }

}
