package com.moviebooking.MovieTicketBooking.controller;

import com.moviebooking.MovieTicketBooking.domain.*;
import com.moviebooking.MovieTicketBooking.service.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieService movieService;
    public AdminController(MovieService movieService) { this.movieService = movieService; }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"ROLE_ADMIN".equals(user.getRole())) return "redirect:/login";
        
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin_dashboard";
    }

    @PostMapping("/addMovie")
    public String addMovie(Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/addShow")
    public String addShow(@RequestParam Long movieId, @RequestParam String screenName, 
                          @RequestParam String showTime, @RequestParam Double price) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
            ShowTiming show = new ShowTiming();
            show.setMovie(movie);
            show.setScreenName(screenName);
            show.setShowTime(LocalDateTime.parse(showTime));
            show.setPrice(price);
            movieService.saveShowTiming(show);
        }
        return "redirect:/admin/dashboard";
    }
}
