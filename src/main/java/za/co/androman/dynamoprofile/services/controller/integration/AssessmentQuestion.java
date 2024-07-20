package za.co.androman.dynamoprofile.services.controller.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AssessmentQuestion {
    private Long id;
    private String question;
    private String description;
    private Blob image;
    private boolean isImageBeforeDescription;
    private List<AssessmentQuestionAnswer> answers;
}
