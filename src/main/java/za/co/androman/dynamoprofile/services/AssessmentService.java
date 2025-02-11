package za.co.androman.dynamoprofile.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.entities.Assessment;
import za.co.androman.dynamoprofile.repositories.AssessmentRepository;


import java.util.List;

@Service
@Slf4j
public class AssessmentService {
    @Autowired
    private AssessmentRepository assessmentRepository;

    public Assessment findById(long id){
        return assessmentRepository.findById(id).orElse(null);
    }
    public List<Assessment> findByUserProfileId(long userProfileId){
        return assessmentRepository.findByUserProfileId(userProfileId);
    }

    public Assessment add(Assessment assessment){
        log.info("Saving assessment : {}", assessment);

        return assessmentRepository.save(assessment);
    }

    public Assessment update(Assessment assessment){
        return assessmentRepository.save(assessment);
    }

    public void delete(Assessment assessment){
        assessmentRepository.delete(assessment);
    }

}
