package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@Entity
@Table(name = "assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    private UserProfile userProfile;
    @ManyToOne
    private AssessmentCategory assessmentCategory;

    @OneToMany(mappedBy = "assessment")
    @LastModifiedDate
    private List<AssessmentQuestion> questions;

}
