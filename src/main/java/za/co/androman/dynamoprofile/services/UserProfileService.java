package za.co.androman.dynamoprofile.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.androman.dynamoprofile.entities.UserProfile;
import za.co.androman.dynamoprofile.repositories.UserProfileRepository;

@Slf4j
@Component
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }


    public void add(UserProfile userProfile){
        this.userProfileRepository.save(userProfile);
    }

    public void delete(UserProfile userProfile){
        this.userProfileRepository.delete(userProfile);
    }

    public void update(UserProfile userProfile){
        this.delete(userProfile);
    }

    public UserProfile find(Long profileId){
        return this.userProfileRepository.findById(profileId).orElse(null);
    }
}
