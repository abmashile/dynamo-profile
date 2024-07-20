package za.co.androman.dynamoprofile.services.integration.tranformers;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.services.controller.integration.Assessment;
import za.co.androman.dynamoprofile.services.controller.integration.AssessmentQuestion;
import za.co.androman.dynamoprofile.services.controller.integration.User;
import za.co.androman.dynamoprofile.services.controller.integration.UserProfile;

import java.util.ArrayList;
import java.util.List;


@Service
public class DefaultTransformer implements DTOMapper {
    private final Mapper dozerMapper;

    @Autowired
    public DefaultTransformer(Mapper dozerMapper){
        this.dozerMapper = dozerMapper;
    }

    @Override
    public AssessmentQuestion transform(za.co.androman.dynamoprofile.entities.AssessmentQuestion modelQuestion){
        return dozerMapper.map(modelQuestion, AssessmentQuestion.class);
    }

    @Override
    public za.co.androman.dynamoprofile.entities.AssessmentQuestion transform(AssessmentQuestion modelQuestion){
        return dozerMapper.map(modelQuestion, za.co.androman.dynamoprofile.entities.AssessmentQuestion.class);
    }

    @Override
    public User transform(za.co.androman.dynamoprofile.entities.User user){
        User extUser = dozerMapper.map(user, User.class);
        List<za.co.androman.dynamoprofile.entities.UserProfile> entProfiles = user.getProfiles();
        List<UserProfile> profiles = new ArrayList<>(entProfiles.size());
        entProfiles.forEach(profile -> profiles.add(transform(profile)));
        extUser.setProfiles(profiles.isEmpty() ? null : profiles);
        return extUser;
    }

    @Override
    public List<User> transform(List<za.co.androman.dynamoprofile.entities.User> users){
        List<User> externUsers =  new ArrayList<>(users.size());
        users.stream().forEach(user->externUsers.add(transform(user)));
        return externUsers;
    }


    @Override
    public za.co.androman.dynamoprofile.entities.User transform(User user){
        return dozerMapper.map(user, za.co.androman.dynamoprofile.entities.User.class);
    }


    @Override
    public Assessment transform(za.co.androman.dynamoprofile.entities.Assessment assessment){
        return dozerMapper.map(assessment, Assessment.class);
    }

    @Override
    public za.co.androman.dynamoprofile.entities.Assessment transform(Assessment assessment){
        za.co.androman.dynamoprofile.entities.Assessment entAssessment = dozerMapper.map(assessment, za.co.androman.dynamoprofile.entities.Assessment.class);
        entAssessment.getQuestions().forEach(entQuestion -> {
            entQuestion.setAssessment(entAssessment);
            entQuestion.getAnswers().forEach(answer-> answer.setQuestion(entQuestion));
        });
        return entAssessment;
    }

    @Override
    public UserProfile transform(za.co.androman.dynamoprofile.entities.UserProfile userProfile){
        UserProfile extProfile = dozerMapper.map(userProfile, UserProfile.class);
        extProfile.setUser(null);
        return extProfile;
    }

    @Override
    public za.co.androman.dynamoprofile.entities.UserProfile transform(UserProfile userProfile){
        return dozerMapper.map(userProfile, za.co.androman.dynamoprofile.entities.UserProfile.class);
    }

}
