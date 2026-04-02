package com.moviebooking.MovieTicketBooking.service;
import com.moviebooking.MovieTicketBooking.domain.User;
import com.moviebooking.MovieTicketBooking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }
    
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    
    public User authenticate(String username, String password) {
        return userRepository.findByUsername(username)
            .filter(u -> u.getPassword().equals(password))
            .orElse(null);
    }
}
