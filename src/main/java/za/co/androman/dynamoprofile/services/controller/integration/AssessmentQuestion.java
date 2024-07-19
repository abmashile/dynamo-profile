package za.co.androman.dynamoprofile.services.controller.integration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@Builder
public class AssessmentQuestion {
    private long id;
    private String question;
    private String description;
    private Blob image;
    private boolean isImageBeforeDescription;
    private AssessmentQuestionAnswer answer;
}
