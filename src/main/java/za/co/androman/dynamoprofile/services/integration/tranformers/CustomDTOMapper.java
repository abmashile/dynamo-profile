package za.co.androman.dynamoprofile.services.integration.tranformers;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.services.controller.integration.Assessment;
import za.co.androman.dynamoprofile.services.controller.integration.AssessmentQuestion;
import za.co.androman.dynamoprofile.services.controller.integration.User;
import za.co.androman.dynamoprofile.services.controller.integration.UserProfile;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomDTOMapper implements DTOMapper{
    private final MapperFacade orikaMapperFacade;

    @Autowired
    public CustomDTOMapper(MapperFacade orikaMapperFacade){
        this.orikaMapperFacade = orikaMapperFacade;
    }

    public AssessmentQuestion transform(za.co.androman.dynamoprofile.entities.AssessmentQuestion modelQuestion){
        return orikaMapperFacade.map(modelQuestion, AssessmentQuestion.class);
    }

    public za.co.androman.dynamoprofile.entities.AssessmentQuestion transform(AssessmentQuestion modelQuestion){
        return orikaMapperFacade.map(modelQuestion, za.co.androman.dynamoprofile.entities.AssessmentQuestion.class);
    }

    public User transform(za.co.androman.dynamoprofile.entities.User user){
        User extUser = orikaMapperFacade.map(user, User.class);
        extUser.getProfiles().forEach(profile-> {
            profile.setUser(null);
            profile.getAssessments().forEach(assessment -> {
                assessment.setUserProfile(null);
                assessment.setQuestions(null);
            });
        });

        return extUser;
    }

    public List<User> transform(List<za.co.androman.dynamoprofile.entities.User> users){
        List<User> externUsers =  new ArrayList<>(users.size());
        users.stream().forEach(user->externUsers.add(transform(user)));
        return externUsers;
    }


    public za.co.androman.dynamoprofile.entities.User transform(User user){
        return orikaMapperFacade.map(user, za.co.androman.dynamoprofile.entities.User.class);
    }


    public Assessment transform(za.co.androman.dynamoprofile.entities.Assessment entAssessment){
        Assessment assessment = orikaMapperFacade.map(entAssessment, Assessment.class);
        assessment.setUserProfile(null);
        assessment.setQuestions(null);
        return assessment;
    }

    public za.co.androman.dynamoprofile.entities.Assessment transform(Assessment assessment){
        za.co.androman.dynamoprofile.entities.Assessment entAssessment = orikaMapperFacade.map(assessment, za.co.androman.dynamoprofile.entities.Assessment.class);
        return entAssessment;
    }

    public UserProfile transform(za.co.androman.dynamoprofile.entities.UserProfile entProfile){
        UserProfile profile = orikaMapperFacade.map(entProfile, UserProfile.class);
        profile.setUser(null);
        profile.getAssessments().forEach(assessment -> {
            assessment.setUserProfile(null);
            assessment.setQuestions(null);
        });
        return profile;
    }

    public za.co.androman.dynamoprofile.entities.UserProfile transform(UserProfile userProfile){
        return orikaMapperFacade.map(userProfile, za.co.androman.dynamoprofile.entities.UserProfile.class);
    }

}
