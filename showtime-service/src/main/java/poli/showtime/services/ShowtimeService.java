package poli.showtime.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import poli.showtime.clients.MovieClient;
import poli.showtime.entities.Showtime;
import poli.showtime.repositories.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeService implements poli.showtime.services.Service<Showtime, Long> {

    @Autowired
    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;


    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        List<Showtime> showtimes = showtimeRepository.findAll();
        if (!showtimes.isEmpty()) {
            for (Showtime showtime: showtimes) {
                showtime.setMovies(showtime.getMoviesId().stream().map(
                        movieId -> movieClient.findById(movieId)).collect(Collectors.toList())
                );
            }
        }
        return showtimes;
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime getByID(Long id) {
        Optional<Showtime> showtimeOptional = showtimeRepository.findById(id);
        if (showtimeOptional.isPresent()) {
            Showtime showtime = showtimeOptional.get();
            showtime.setMovies(showtime.getMoviesId().stream().map(
                    movieId -> movieClient.findById(movieId)).collect(Collectors.toList())
            );
            return showtime;
        }
        return null;
    }

    @Override
    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime delete(Long id) {
        Optional<Showtime> toDelete = showtimeRepository.findById(id);
        if(toDelete.isPresent()){
            showtimeRepository.deleteById(id);
            return toDelete.get();
        }
        return null;
    }

    @Override
    public Showtime edit(Long id, Showtime showtime) {
        Optional<Showtime> toUpdate = showtimeRepository.findById(id);
        if(toUpdate.isPresent()){
            showtimeRepository.save(toUpdate.get());
            return toUpdate.get();
        }
        return null;
    }
}
