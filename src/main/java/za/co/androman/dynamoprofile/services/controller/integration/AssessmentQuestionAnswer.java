package za.co.androman.dynamoprofile.services.controller.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@Builder
public class AssessmentQuestionAnswer {
  private long id;
  private String answer;
  private String description;
  private Blob image;
}
