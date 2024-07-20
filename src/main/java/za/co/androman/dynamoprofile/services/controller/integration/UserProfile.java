package za.co.androman.dynamoprofile.services.controller.integration;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserProfile {

    private Long id;
    private String name;
    private User user;
    @JsonProperty("isActive")
    private boolean isActive;
    private List<Assessment> assessments;
}
