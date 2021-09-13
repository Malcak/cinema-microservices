package poli.movie.models;

import lombok.Data;
import poli.movie.entities.Movie;

import java.util.Date;
import java.util.List;

@Data
public class Showtime {

    private Long id;
    private Date date;
    private List<Long> moviesId;

}

