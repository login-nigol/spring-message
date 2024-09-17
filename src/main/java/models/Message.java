package models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_email", nullable = false)
    private String fromEmail;

    @Column(name = "to_email", nullable = false)
    private String toEmail;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "sent_date", nullable = false)
    private LocalDateTime sentDate;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
