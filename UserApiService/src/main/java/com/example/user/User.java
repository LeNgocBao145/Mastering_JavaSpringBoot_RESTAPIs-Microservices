package com.example.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String name;
	
	private Post posts;
	private Notification notifications;
	
	public User(int id1, String name1) {
		this.name = name1;
		this.id = id1;
	}
}
