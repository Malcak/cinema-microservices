package poli.movie.clients;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import poli.movie.models.Booking;
import poli.movie.models.Showtime;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class ShowtimeClientFallBackHystrix implements ShowtimeClient {
    @Override
    public List<Showtime> findAllByMovieId(Long movieid) {
        List<Showtime> showtimes = new ArrayList<Showtime>();
        Showtime newShowtime = new Showtime();
        List<Long> moviesId = new ArrayList<>();
        moviesId.add(movieid);
        newShowtime.setMoviesId(moviesId);
        showtimes.add(newShowtime);
        return showtimes;
    }
}
