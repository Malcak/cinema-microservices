package poli.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poli.booking.entities.Booking;
import poli.booking.repositories.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService implements poli.booking.service.Service<Booking, Long> {

    private final BookingRepository bookingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Booking getById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAllByUserId(Long id) {
        return bookingRepository.findAllByUserId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Booking delete(Long id) {
        Optional<Booking> toDelete = bookingRepository.findById(id);
        if (toDelete.isPresent()) {
            bookingRepository.deleteById(id);
            return toDelete.get();
        }
        return null;
    }

}
