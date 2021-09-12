package poli.booking.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import poli.booking.models.Movie;

@FeignClient(name = "movie-service")
@RequestMapping("/movies")
public interface MovieClient {
    @GetMapping("/{id}")
    Movie findById(@PathVariable("id") Long id);
}
