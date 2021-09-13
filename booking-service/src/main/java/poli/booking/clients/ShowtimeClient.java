package poli.booking.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.booking.models.Showtime;

@FeignClient(name = "showtime-service", fallback = ShowtimeClientFallBackHystrix.class)
public interface ShowtimeClient {
    @GetMapping("/showtimes/{id}")
    Showtime findById(@PathVariable("id") Long id);
}
