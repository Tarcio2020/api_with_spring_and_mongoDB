package com.tarcioteles.apiWithMongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarcioteles.apiWithMongodb.domain.User;
import com.tarcioteles.apiWithMongodb.dto.UserDTO;
import com.tarcioteles.apiWithMongodb.repositories.UserRepository;
import com.tarcioteles.apiWithMongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll (){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}else {
		return user;
		}
	}

	public User create(User obj) {
		return userRepository.save(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);//busca primeiro para aproveitar o tratamento de erro..
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
	    User newObj = userRepository.findById(obj.getId())
	            .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + obj.getId()));
	    updateData(newObj, obj);
	    return userRepository.save(newObj);
	}

	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName());
	    newObj.setEmail(obj.getEmail());
	}
	
}
