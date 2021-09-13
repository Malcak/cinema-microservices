package poli.showtime.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.showtime.entities.Showtime;
import poli.showtime.services.ShowtimeService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {
    private final ShowtimeService showtimeService;
    
    @GetMapping
    public ResponseEntity<List<Showtime>> findAll(){
        List<Showtime> showtimes = showtimeService.findAll();
        if (showtimes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(showtimes);
    }

    @PostMapping
    public ResponseEntity<Showtime> save(@Valid @RequestBody Showtime showtime){
        return ResponseEntity.status(HttpStatus.CREATED).body(showtimeService.save(showtime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Showtime> delete(@Valid @PathVariable("id") Long id) {
        Showtime showtime = showtimeService.delete(id);
        if (showtime == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(showtime);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> findById(@Valid @PathVariable("id") Long id) {
        Showtime showtime = showtimeService.getByID(id);
        if (showtime == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(showtime);
    }

    @GetMapping("/movies/{movieid}")
    public ResponseEntity<List<Showtime>> findAllByMovieId(@Valid @PathVariable("movieid") Long movieid) {
        List<Showtime> showtimes = showtimeService.getAllByMovieId(movieid);
        if (showtimes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(showtimes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> edit(@Valid @PathVariable("id") Long id, @Valid @RequestBody Showtime showtime) {
        Showtime showtimeVerify = showtimeService.edit(id,showtime);
        if (showtimeVerify == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(showtimeVerify);
    }
}
