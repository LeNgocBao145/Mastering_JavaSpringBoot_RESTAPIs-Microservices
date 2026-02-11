package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private WebClient webClient;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		User user = new User(1, "ABC");
		
		Post posts = webClient.get()
							.uri("http://post-service/posts/1")
							.retrieve()
							.bodyToMono(Post.class)
							.block();
		
		Notification notifications = webClient.get()
				.uri("http://notification-service/notifications/1")
				.retrieve()
				.bodyToMono(Notification.class)
				.block();
		
		user.setPosts(posts);
		user.setNotifications(notifications);
		return user;
	}
}
