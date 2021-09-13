package poli.movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import poli.movie.entities.Movie;
import poli.movie.repositories.MovieRepository;
import poli.movie.services.MovieService;
import poli.movie.services.Service;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;
    private Service service;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        service = new MovieService(movieRepository);

        Movie movie = new Movie(6L,"The ring","Gore Verbinski",4);
        Mockito.when(movieRepository.findById(6L)).thenReturn(Optional.of(movie));
    }
    @Test
    public void when_getById_return_movie(){
        Movie movie = (Movie) service.getByID(6L);
        Assertions.assertThat(movie.getDirector()).isEqualTo("Gore Verbinski");
    }
}
