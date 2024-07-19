package za.co.androman.dynamoprofile.services.controller.integration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class Assessment {
    private long id;
    private UserProfile userProfile;
    private AssessmentCategoryType assessmentCategory;
    private List<AssessmentQuestion> questions;

}
