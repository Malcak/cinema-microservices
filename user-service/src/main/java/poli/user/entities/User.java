package poli.user.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, unique = true)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Last name is required")
    @Column(name="lastname")
    private String lastname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
