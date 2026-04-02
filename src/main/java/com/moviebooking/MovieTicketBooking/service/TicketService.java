package com.moviebooking.MovieTicketBooking.service;
import com.moviebooking.MovieTicketBooking.domain.*;
import com.moviebooking.MovieTicketBooking.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public Ticket bookTicket(User user, ShowTiming show, String seatNumber) {
        // Prevent double booking
        boolean isBooked = ticketRepository.findByShowTimingIdAndSeatNumberAndStatus(show.getId(), seatNumber, "BOOKED").isPresent();
        if (isBooked) {
            throw new RuntimeException("Seat is already booked!");
        }

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowTiming(show);
        ticket.setSeatNumber(seatNumber);
        ticket.setStatus("BOOKED");
        ticket.setBookingTime(LocalDateTime.now());
        
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getUserTickets(Long userId) {
        return ticketRepository.findByUserId(userId);
    }
    
    public List<String> getBookedSeats(Long showId) {
        return ticketRepository.findByShowTimingId(showId).stream()
                .filter(t -> "BOOKED".equals(t.getStatus()))
                .map(Ticket::getSeatNumber)
                .toList();
    }
}
