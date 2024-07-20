package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="assessmentcategory")
public class AssessmentCategory {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private AssessmentCategoryType assessmentCategoryType;

    @OneToMany(mappedBy = "assessmentCategory")
    private List<Assessment> assessments;
}
