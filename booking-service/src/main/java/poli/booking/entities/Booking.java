package poli.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poli.booking.models.Movie;
import poli.booking.models.User;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull(message = "User's id cannot be null")
    @Column(name = "user_id")
    private Long userId;
    @Transient
    private User user;

    @NotNull(message = "Showtime id cannot be null")
    @Column(name = "showtime_id")
    private Long showtimeId;
    // TODO: transient showtime;

    @Valid
    @ElementCollection
    @CollectionTable(name="movies", joinColumns=@JoinColumn(name="booking_id"))
    @Column(name="movies")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Long> moviesId;
    @Transient
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
