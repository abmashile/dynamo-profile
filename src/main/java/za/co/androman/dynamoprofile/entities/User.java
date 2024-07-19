package za.co.androman.dynamoprofile.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "systemuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column(unique = true)
    private String username;
    String name, surname;
    private Date dateOfBirth;
    @ColumnDefault("false")
    private boolean isActive;
    @OneToMany(mappedBy = "user")
    private List<UserProfile> profiles;
}
