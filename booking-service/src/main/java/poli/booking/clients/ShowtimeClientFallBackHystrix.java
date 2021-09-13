package poli.booking.clients;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poli.booking.models.Showtime;

@Component
@NoArgsConstructor
public class ShowtimeClientFallBackHystrix implements ShowtimeClient{
    @Override
    public Showtime findById(Long id) {
        return null;
    }
}
