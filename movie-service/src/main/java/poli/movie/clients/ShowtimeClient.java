package poli.movie.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.movie.models.Showtime;

import java.util.List;

@FeignClient(name = "showtime-service", fallback = ShowtimeClientFallBackHystrix.class)
public interface ShowtimeClient {
    @GetMapping("/showtimes/movies/{movieid}")
    List<Showtime> findAllByMovieId(@PathVariable("movieid") Long id);
}
