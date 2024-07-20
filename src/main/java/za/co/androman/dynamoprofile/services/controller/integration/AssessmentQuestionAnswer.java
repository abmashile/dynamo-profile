package za.co.androman.dynamoprofile.services.controller.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Blob;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AssessmentQuestionAnswer {
  private long id;
  private String answer;
  @JsonProperty("isCorrect")
  private boolean isCorrect;
  private String description;
  private Blob image;
}
