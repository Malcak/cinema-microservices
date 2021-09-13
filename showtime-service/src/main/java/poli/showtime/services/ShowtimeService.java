package poli.showtime.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import poli.showtime.entities.Showtime;
import poli.showtime.repositories.ShowtimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimeService implements poli.showtime.services.Service<Showtime, Long> {

    @Autowired
    ShowtimeRepository showtimeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime getByID(Long id) {
        return showtimeRepository.findById(id).orElse(null);
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
