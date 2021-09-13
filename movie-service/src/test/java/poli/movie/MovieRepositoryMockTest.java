package poli.movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import poli.movie.entities.Movie;
import poli.movie.repositories.MovieRepository;

import java.util.List;

@DataJpaTest
public class MovieRepositoryMockTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findAll_return_ListMovies(){
        Movie movie = new Movie(1L,"The ring","Gore Verbinski",4);
        movieRepository.save(movie);

        List<Movie> movies = movieRepository.findAll();
        Assertions.assertThat(movies.size()).isEqualTo(1);
    }
}
