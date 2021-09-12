package poli.booking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.booking.entities.Booking;
import poli.booking.service.BookingService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> bookings = bookingService.findAll();
        if (bookings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@Valid @PathVariable("id") Long id) {
        Booking booking = bookingService.getById(id);
        if (booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> save(@Valid @RequestBody Booking booking){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> delete(@Valid @PathVariable("id") Long id) {
        Booking booking = bookingService.delete(id);
        if (booking == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Booking>> findAllByUserId(@Valid @PathVariable("userid") Long userid) {
        List<Booking> bookings = bookingService.getAllByUserId(userid);
        if (bookings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

}
