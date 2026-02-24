package org.example.service.mockService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.service.NotificationService;

@Getter
@Setter
@AllArgsConstructor
public class MockNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("MockNotificationService: " + message);
    }
}
