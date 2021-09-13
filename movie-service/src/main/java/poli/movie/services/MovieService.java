package poli.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import poli.movie.clients.BookingClient;
import poli.movie.clients.ShowtimeClient;
import poli.movie.entities.Movie;
import poli.movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements poli.movie.services.Service<Movie,Long> {

    @Autowired
    private final MovieRepository movieRepository;
    private final ShowtimeClient showtimeClient;
    private final BookingClient bookingClient;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
       return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie getByID(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Movie delete(Long id) {
        Optional<Movie> toDelete = movieRepository.findById(id);
        if(toDelete.isPresent() && showtimeClient.findAllByMovieId(id) == null || bookingClient.getAllByMovieId(id) == null){
            movieRepository.deleteById(id);
            return toDelete.get();
        }
        return null;
    }

}
