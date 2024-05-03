package com.devcarlosgti.courseSprint.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devcarlosgti.courseSprint.entities.User;
import com.devcarlosgti.courseSprint.repositories.UserRepository;

//Classe para test
@Configuration
@Profile("test")//esse vem la do meu application.properties(spring.profiles.active=test)
public class TestConfig implements CommandLineRunner{
	//CommandLineRunner e um inteface q execute a aplicação e esta dentro do metodo run
	
	//vamos criar depedencia(@Autowired)
	@Autowired
	private UserRepository userRepository;//ele acesso os dados

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		//vamos salvar no database
		userRepository.saveAll(Arrays.asList(u1,u2));//estou salvando uma lista de users
	}

}
