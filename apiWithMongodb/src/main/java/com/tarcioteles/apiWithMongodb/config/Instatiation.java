package com.tarcioteles.apiWithMongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tarcioteles.apiWithMongodb.domain.Post;
import com.tarcioteles.apiWithMongodb.domain.User;
import com.tarcioteles.apiWithMongodb.dto.AuthorDTO;
import com.tarcioteles.apiWithMongodb.repositories.PostRepository;
import com.tarcioteles.apiWithMongodb.repositories.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");		

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem!!!", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("10/04/2018"), "Dia de churrasco", "Hoje tem churrasco com os amigos!", new AuthorDTO(alex));
		Post post3 = new Post(null, sdf.parse("05/05/2018"), "Estudando Java", "Aprendendo mais sobre orientação a objetos.", new AuthorDTO(bob));
		Post post4 = new Post(null, sdf.parse("15/06/2018"), "Fim de semana na praia", "Aproveitando o sol e o mar com a família.", new AuthorDTO(bob));

		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
