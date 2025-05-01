package com.tarcioteles.apiWithMongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarcioteles.apiWithMongodb.domain.Post;
import com.tarcioteles.apiWithMongodb.repositories.PostRepository;
import com.tarcioteles.apiWithMongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	public Post findById(String id) {
	    return postRepository.findById(id)
	            .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com id: " + id));
	}
	
}
