
package br.com.barrostech.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.barrostech.model.User;
import br.com.barrostech.repositories.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		
		List<User> users = repository.findAll();
		repository.deleteAll(users);
		if(users.isEmpty()) {
			this.createUsers("Emerson Barros", "kaua54@hotmail.com", "123456");
			this.createUsers("Kauã Barros", "kk@hotmail.com", "123456");
			this.createUsers("Alice Barros", "alice@hotmail.com", "123456");
			
		}
	}
	public void createUsers( String name, String email, String password) {
		User user  = new User(name, email, password);
		repository.save(user);
	}

}
