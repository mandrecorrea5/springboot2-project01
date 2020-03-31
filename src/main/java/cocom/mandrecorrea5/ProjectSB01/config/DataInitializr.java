package cocom.mandrecorrea5.ProjectSB01.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cocom.mandrecorrea5.ProjectSB01.entity.User;
import cocom.mandrecorrea5.ProjectSB01.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			createUser("Amanda Gomes", "mousinho.amanda@gmail.com");
			createUser("Pedro Lucas", "pedroLucas@gmail.com");
		}				
		
		User user = userRepository.findByName("Pedr");
		
		System.out.println(user.getEmail());
		
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}
