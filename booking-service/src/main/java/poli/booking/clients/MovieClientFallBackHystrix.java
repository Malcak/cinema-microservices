package poli.booking.clients;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poli.booking.models.Movie;

@Component
@NoArgsConstructor
public class MovieClientFallBackHystrix implements MovieClient {
    @Override
    public Movie findById(Long id) {
        return null;
    }
}