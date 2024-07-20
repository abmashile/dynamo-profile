package za.co.androman.dynamoprofile.services.integration.tranformers;

import za.co.androman.dynamoprofile.services.controller.integration.Assessment;
import za.co.androman.dynamoprofile.services.controller.integration.AssessmentQuestion;
import za.co.androman.dynamoprofile.services.controller.integration.User;
import za.co.androman.dynamoprofile.services.controller.integration.UserProfile;

import java.util.List;

public interface DTOMapper {
    AssessmentQuestion transform(za.co.androman.dynamoprofile.entities.AssessmentQuestion modelQuestion);

    za.co.androman.dynamoprofile.entities.AssessmentQuestion transform(AssessmentQuestion modelQuestion);

    User transform(za.co.androman.dynamoprofile.entities.User user);

    List<User> transform(List<za.co.androman.dynamoprofile.entities.User> users);

    za.co.androman.dynamoprofile.entities.User transform(User user);

    Assessment transform(za.co.androman.dynamoprofile.entities.Assessment assessment);

    za.co.androman.dynamoprofile.entities.Assessment transform(Assessment assessment);

    UserProfile transform(za.co.androman.dynamoprofile.entities.UserProfile userProfile);

    za.co.androman.dynamoprofile.entities.UserProfile transform(UserProfile userProfile);
}
