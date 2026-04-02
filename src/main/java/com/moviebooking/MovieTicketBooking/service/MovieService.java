package com.moviebooking.MovieTicketBooking.service;
import com.moviebooking.MovieTicketBooking.domain.Movie;
import com.moviebooking.MovieTicketBooking.domain.ShowTiming;
import com.moviebooking.MovieTicketBooking.repository.MovieRepository;
import com.moviebooking.MovieTicketBooking.repository.ShowTimingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ShowTimingRepository showTimingRepository;

    public MovieService(MovieRepository movieRepository, ShowTimingRepository showTimingRepository) {
        this.movieRepository = movieRepository;
        this.showTimingRepository = showTimingRepository;
    }

    public List<Movie> getAllMovies() { return movieRepository.findAll(); }
    public Movie saveMovie(Movie movie) { return movieRepository.save(movie); }
    public Movie getMovieById(Long id) { return movieRepository.findById(id).orElse(null); }
    
    public ShowTiming saveShowTiming(ShowTiming showTiming) { return showTimingRepository.save(showTiming); }
    public List<ShowTiming> getShowsForMovie(Long movieId) { return showTimingRepository.findByMovieId(movieId); }
    public ShowTiming getShowTimingById(Long id) { return showTimingRepository.findById(id).orElse(null); }
}
