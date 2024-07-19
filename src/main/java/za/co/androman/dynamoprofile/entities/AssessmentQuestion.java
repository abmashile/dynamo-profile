package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "question")
public class AssessmentQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String question;
    private String description;
    @Column
    private Blob image;
    private boolean isImageBeforeDescription;
    @OneToOne
    private AssessmentQuestionAnswer answer;
    @ManyToOne
    private Assessment assessment;
}
