package poli.showtime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poli.showtime.entities.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
}
