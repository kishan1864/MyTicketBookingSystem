package com.moviebooking.MovieTicketBooking.repository;
import com.moviebooking.MovieTicketBooking.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByShowTimingId(Long showTimingId);
    Optional<Ticket> findByShowTimingIdAndSeatNumberAndStatus(Long showId, String seatNumber, String status);
}
