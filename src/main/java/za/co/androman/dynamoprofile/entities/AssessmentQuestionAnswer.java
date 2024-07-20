package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Blob;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "answer")
public class AssessmentQuestionAnswer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String answer;
  private boolean isCorrect;
  private String description;
  @ManyToOne
  private AssessmentQuestion question;
  private Blob image;
}
