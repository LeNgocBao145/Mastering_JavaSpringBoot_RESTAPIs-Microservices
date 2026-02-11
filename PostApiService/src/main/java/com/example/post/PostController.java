package com.example.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
	@GetMapping("/{id}")
	public Post getPost(@PathVariable int id) {
		Post post = new Post(1, "This is description of post ");
		return post;
	}
}
