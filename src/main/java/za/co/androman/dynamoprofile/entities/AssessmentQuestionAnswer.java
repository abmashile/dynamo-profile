package za.co.androman.dynamoprofile.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "answer")
public class AssessmentQuestionAnswer {
  @Id
  private long id;
  private String answer;
  private String description;
  @OneToOne
  private AssessmentQuestion question;
  private Blob image;
}
