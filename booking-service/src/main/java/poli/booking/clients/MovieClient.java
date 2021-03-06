package poli.booking.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.booking.models.Movie;

@FeignClient(name = "movie-service", fallback = MovieClientFallBackHystrix.class)
public interface MovieClient {
    @GetMapping("/movies/{id}")
    Movie findById(@PathVariable("id") Long id);
}

