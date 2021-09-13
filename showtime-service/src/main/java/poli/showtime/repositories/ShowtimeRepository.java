package poli.showtime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poli.showtime.entities.Showtime;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
    List<Showtime> findAllByMoviesIdContaining(Long id);
}
