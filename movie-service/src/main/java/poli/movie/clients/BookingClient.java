package poli.movie.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.movie.models.Booking;

import java.util.List;

@FeignClient(name = "booking-service", fallback = BookingClientFallBackHystrix.class)
public interface BookingClient {
    @GetMapping("/bookings/movies/{movieid}")
    List<Booking> getAllByMovieId(@PathVariable("movieid") Long movieid);
}
