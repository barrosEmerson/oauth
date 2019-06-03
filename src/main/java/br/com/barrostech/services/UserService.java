package br.com.barrostech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.barrostech.model.User;
import br.com.barrostech.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@CacheEvict(cacheNames="User",allEntries=true)
	public List<User> findAll(Pageable pageable){
		List<User>users = repository.findAll();
		return users;
	}
}
