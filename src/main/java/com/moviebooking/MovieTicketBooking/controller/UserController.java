package com.moviebooking.MovieTicketBooking.controller;

import com.moviebooking.MovieTicketBooking.domain.*;
import com.moviebooking.MovieTicketBooking.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final MovieService movieService;
    private final TicketService ticketService;

    public UserController(MovieService movieService, TicketService ticketService) {
        this.movieService = movieService;
        this.ticketService = ticketService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("tickets", ticketService.getUserTickets(user.getId()));
        return "user_dashboard";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("shows", movieService.getShowsForMovie(id));
        return "movie_details";
    }

    @GetMapping("/book/{showId}")
    public String bookPage(@PathVariable Long showId, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        ShowTiming show = movieService.getShowTimingById(showId);
        List<String> bookedSeats = ticketService.getBookedSeats(showId);
        
        model.addAttribute("show", show);
        model.addAttribute("bookedSeats", bookedSeats);
        return "book_seat";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@RequestParam Long showId, @RequestParam String seatNumber, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        ShowTiming show = movieService.getShowTimingById(showId);
        try {
            ticketService.bookTicket(user, show, seatNumber);
            return "redirect:/user/dashboard?success=true";
        } catch (RuntimeException e) {
            return "redirect:/user/book/" + showId + "?error=" + e.getMessage();
        }
    }
}
