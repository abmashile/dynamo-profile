package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="assemessmentcategory")
public class AssessmentCategory {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private AssessmentCategoryType categoryType;

    @OneToMany(mappedBy = "assessmentCategory")
    private List<Assessment> assessments;
}
