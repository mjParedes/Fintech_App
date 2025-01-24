package com.practice.Notification.dtoResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationUserRequestDto {
    private Long id;
    private String photoUrl;
    private String email;
    private String name;
    private String lastName;
    private Long phoneNumber;
    private LocalDateTime birthDate;
}
