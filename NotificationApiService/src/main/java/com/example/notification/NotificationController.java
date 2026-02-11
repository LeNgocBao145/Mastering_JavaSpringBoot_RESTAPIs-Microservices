package com.example.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	@GetMapping("/{id}")
	public Notification getNotification(@PathVariable int id) {
		Notification notification = new Notification(1, "This is notification");
		return notification;
	}
}
