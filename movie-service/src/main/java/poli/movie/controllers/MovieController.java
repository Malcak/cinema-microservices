package poli.movie.controllers; 

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.movie.entities.Movie;
import poli.movie.services.MovieService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> users = movieService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@Valid @PathVariable("id") Long id) {
        Movie movie = movieService.delete(id);
        if (movie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
