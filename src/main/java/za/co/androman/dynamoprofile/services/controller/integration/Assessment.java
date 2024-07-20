package za.co.androman.dynamoprofile.services.controller.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Assessment {
    private long id;
    private String name;
    private UserProfile userProfile;
    private AssessmentCategory assessmentCategory;
    private List<AssessmentQuestion> questions;
    @JsonProperty("isActive")
    private boolean isActive;
}
