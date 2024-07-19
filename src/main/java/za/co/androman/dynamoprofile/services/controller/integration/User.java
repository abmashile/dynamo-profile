package za.co.androman.dynamoprofile.services.controller.integration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import za.co.androman.dynamoprofile.services.converter.DateOfBirthSerializer;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class User {
    private long userId;
    private String username, name, surname;
   //    @JsonSerialize(using = DateOfBirthSerializer.class)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    //private Date dateOfBirth;
    private boolean isActive;
    private List<UserProfile> profiles;
}
