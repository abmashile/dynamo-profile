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
public class DefaultTransformer {
    private final Mapper dozerMapper;

    @Autowired
    public DefaultTransformer(Mapper dozerMapper){
        this.dozerMapper = dozerMapper;
    }

    public AssessmentQuestion transform(za.co.androman.dynamoprofile.entities.AssessmentQuestion modelQuestion){
        return dozerMapper.map(modelQuestion, AssessmentQuestion.class);
    }

    public za.co.androman.dynamoprofile.entities.AssessmentQuestion transform(AssessmentQuestion modelQuestion){
        return dozerMapper.map(modelQuestion, za.co.androman.dynamoprofile.entities.AssessmentQuestion.class);
    }

    public User transform(za.co.androman.dynamoprofile.entities.User user){
        return dozerMapper.map(user, User.class);
    }

    public List<User> transform(List<za.co.androman.dynamoprofile.entities.User> users){
        List<User> externUsers =  new ArrayList<>(users.size());
        users.stream().forEach(e->{externUsers.add(transform(e));});
        return externUsers;
    }


    public za.co.androman.dynamoprofile.entities.User transform(User user){
        return dozerMapper.map(user, za.co.androman.dynamoprofile.entities.User.class);
    }


    public Assessment transform(za.co.androman.dynamoprofile.entities.Assessment assessment){
        return dozerMapper.map(assessment, Assessment.class);
    }

    public za.co.androman.dynamoprofile.entities.Assessment transform(Assessment assessment){
        return dozerMapper.map(assessment, za.co.androman.dynamoprofile.entities.Assessment.class);
    }

    public UserProfile transform(za.co.androman.dynamoprofile.entities.UserProfile userProfile){
        return dozerMapper.map(userProfile, UserProfile.class);
    }

    public za.co.androman.dynamoprofile.entities.UserProfile transform(UserProfile userProfile){
        return dozerMapper.map(userProfile, za.co.androman.dynamoprofile.entities.UserProfile.class);
    }

}
