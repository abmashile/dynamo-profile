package za.co.androman.dynamoprofile.services.controller.integration;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AssessmentCategory {
    private int id;
    private AssessmentCategoryType assessmentCategoryType;

    private List<Assessment> assessments;
}
