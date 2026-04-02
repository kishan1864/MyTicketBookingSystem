package com.moviebooking.MovieTicketBooking.repository;
import com.moviebooking.MovieTicketBooking.domain.ShowTiming;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowTimingRepository extends JpaRepository<ShowTiming, Long> {
    List<ShowTiming> findByMovieId(Long movieId);
}
