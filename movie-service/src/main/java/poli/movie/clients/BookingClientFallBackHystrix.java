package poli.movie.clients;

import poli.movie.models.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingClientFallBackHystrix implements BookingClient {

    @Override
    public List<Booking> getAllByMovieId(Long movieid) {
        List<Booking> bookings = new ArrayList<Booking>();
        Booking newBooking = new Booking();
        List<Long> moviesId = new ArrayList<>();
        moviesId.add(movieid);
        newBooking.setMoviesId(moviesId);
        bookings.add(newBooking);
        return bookings;
    }
}
