package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private UserProfile userProfile;
    @ManyToOne
    private AssessmentCategory assessmentCategory;
    private boolean isActive;
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL)
    private List<AssessmentQuestion> questions;

}
