package za.co.androman.dynamoprofile.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private User user;
    private boolean isActive;
    @OneToMany(mappedBy = "userProfile")
    private List<Assessment> assessments;
}
