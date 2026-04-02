package com.moviebooking.MovieTicketBooking;

import com.moviebooking.MovieTicketBooking.domain.User;
import com.moviebooking.MovieTicketBooking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepository) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword("admin");
				admin.setEmail("admin@moviebooking.com");
				admin.setRole("ROLE_ADMIN");
				userRepository.save(admin);
			}
		};
	}
}
