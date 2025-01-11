package com.practice.Notification.model;


import com.practice.Notification.Enum.EnumTypeNotification;
import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "notifications")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_notification")
    private EnumTypeNotification type;
    private String message;
    private LocalDateTime dateCreate = LocalDateTime.now();
    private Boolean isRead;
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel user;
}
