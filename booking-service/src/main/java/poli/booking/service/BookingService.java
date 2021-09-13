package poli.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poli.booking.clients.MovieClient;
import poli.booking.clients.ShowtimeClient;
import poli.booking.clients.UserClient;
import poli.booking.entities.Booking;
import poli.booking.repositories.BookingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService implements poli.booking.service.Service<Booking, Long> {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final MovieClient movieClient;
    private final ShowtimeClient showtimeClient;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        if (!bookings.isEmpty()) {
            for (Booking booking : bookings) {
                booking.setUser(userClient.findById(booking.getUserId()));
                booking.setShowtime(showtimeClient.findById(booking.getShowtimeId()));
                booking.setMovies(booking.getMoviesId().stream().map(
                        movieId -> movieClient.findById(movieId)).collect(Collectors.toList())
                );
            }
        }
        return bookings;
    }

    @Override
    @Transactional(readOnly = true)
    public Booking getById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setUser(userClient.findById(booking.getUserId()));
            booking.setShowtime(showtimeClient.findById(booking.getShowtimeId()));
            booking.setMovies(booking.getMoviesId().stream().map(movieId -> movieClient.findById(movieId)).collect(Collectors.toList()));
            return booking;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllByUserId(Long id) {

        List<Booking> bookings = bookingRepository.findAllByUserId(id);
        if (!bookings.isEmpty()) {
            for (Booking booking : bookings) {
                booking.setUser(userClient.findById(booking.getUserId()));
                booking.setShowtime(showtimeClient.findById(booking.getShowtimeId()));
                booking.setMovies(booking.getMoviesId().stream().map(
                        movieId -> movieClient.findById(movieId)).collect(Collectors.toList())
                );
            }
        }
        return bookings;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllByMovieId(Long id) {
        List<Booking> bookings = bookingRepository.findAllByMoviesIdContaining(id);
        if (bookings.isEmpty()) {
            for (Booking booking : bookings) {
                booking.setUser(userClient.findById(booking.getUserId()));
                booking.setShowtime(showtimeClient.findById(booking.getShowtimeId()));
            }
        }
        return bookings;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Booking delete(Long id) {
        Optional<Booking> toDelete = bookingRepository.findById(id);
        if (toDelete.isPresent()) {
            bookingRepository.deleteById(id);
            return toDelete.get();
        }
        return null;
    }

}
