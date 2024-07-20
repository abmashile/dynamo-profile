package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "question")
public class AssessmentQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String description;
    private Blob image;
    private boolean isImageBeforeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<AssessmentQuestionAnswer> answers;
    @ManyToOne
    private Assessment assessment;
}
