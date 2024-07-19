package za.co.androman.dynamoprofile.services.controller.integration;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.androman.dynamoprofile.entities.Assessment;

import java.util.List;


public class UserProfile {

    private Long id;
    private String name;
    private User user;
    private boolean isActive;
    private List<Assessment> assessments;
}
