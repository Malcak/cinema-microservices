package poli.showtime.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poli.showtime.models.Movie;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "showtimes")
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "Date of the showtime is required")
    @Column(name = "date", nullable = false)
    private Date date;

    @Valid
    @ElementCollection
    @CollectionTable(name="movies", joinColumns=@JoinColumn(name="showtime_id"))
    @Column(name="movies")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Long> moviesId;
    @Transient
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return id.equals(showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
