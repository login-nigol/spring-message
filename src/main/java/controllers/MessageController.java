package controllers;

import models.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import services.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestParam String toEmail, @RequestParam String text, Principal principal) {
        String fromEmail = principal.getName();  // Получение email текущего пользователя
        Message message = messageService.sendMessage(fromEmail, toEmail, text);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<Page<Message>> getMessages(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size,
            Principal principal) {

        String toEmail = principal.getName(); // Получаем email текущего пользователя
        Pageable pageable = PageRequest.of(page, size); // Пагинация

        Page<Message> messages = messageService.getMessages(toEmail, pageable);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Message>> getMessagesFromSender(@RequestParam String fromEmail, Principal principal) {
        String toEmail = principal.getName();
        List<Message> messages = messageService.getMessagesFromSender(toEmail, fromEmail);
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
