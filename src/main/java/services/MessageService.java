package services;

import models.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(String fromEmail, String toEmail, String text) {
        Message message = new Message();
        message.setFromEmail(fromEmail);
        message.setToEmail(toEmail);
        message.setText(text);
        message.setSentDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Page<Message> getMessages(String toEmail, Pageable pageable) {
        return messageRepository.findByToEmailAndIsDeletedFalse(toEmail, pageable);
    }

    public List<Message> getMessagesFromSender(String toEmail, String fromEmail) {
        return messageRepository.findByToEmailAndFromEmailAndIsDeletedFalse(toEmail, fromEmail);
    }

    public void deleteMessage(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Сообщение не найдено"));
        message.setDeleted(true);
        messageRepository.save(message);
    }
}
