package poli.movie.services;

import poli.movie.entities.Movie;
import poli.movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements poli.movie.services.Service<Movie,Long> {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
       return movieRepository.findAll();
    }

    @Override
    public Movie getByID(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(Long id) {
        Optional<Movie> toDelete = movieRepository.findById(id);
        if(toDelete.isPresent()){
            movieRepository.deleteById(id);
            return toDelete.get();
        }
        return null;
    }

}
