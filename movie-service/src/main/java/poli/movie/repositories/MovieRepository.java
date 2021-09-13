package poli.movie.repositories;

import org.springframework.stereotype.Repository;
import poli.movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
