package za.co.androman.dynamoprofile.services.controller.integration;

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
public class User {
    private Long userId;
    private String username, name, surname;
   //    @JsonSerialize(using = DateOfBirthSerializer.class)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    //private Date dateOfBirth;
    @JsonProperty("isActive")
    private boolean isActive;
    private List<UserProfile> profiles;
}
