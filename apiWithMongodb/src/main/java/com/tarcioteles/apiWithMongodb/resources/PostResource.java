package com.tarcioteles.apiWithMongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarcioteles.apiWithMongodb.domain.Post;
import com.tarcioteles.apiWithMongodb.domain.User;
import com.tarcioteles.apiWithMongodb.dto.UserDTO;
import com.tarcioteles.apiWithMongodb.services.PostService;
import com.tarcioteles.apiWithMongodb.services.UserService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findPosts(@PathVariable String id) {
	    Post obj = postService.findById(id); 
	    return ResponseEntity.ok().body(obj);
	}


}

