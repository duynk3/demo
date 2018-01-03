package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	 @Bean(name="passwordEncoder")
//	    public PasswordEncoder configurePasswordEncoder() {
//	      return  new BCryptPasswordEncoder(64);
//	    }
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we
	 * coded.
	 * 
	 * @param builder
	 * @param repository
	 * @throws Exception
	 */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository)
			throws Exception {
		// Setup a default user if db is empty
		builder.userDetailsService(userDetailsService(repository));
	}

	/**
	 * We return an istance of our CustomUserDetails.
	 * 
	 * @param repository
	 * @return
	 */
	private UserDetailsService userDetailsService(final UserRepository repository) {
		System.out.println("--------------------------");
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}

}
