package za.co.androman.dynamoprofile.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.androman.dynamoprofile.entities.Assessment;

import java.util.List;

public interface AssessmentRepository extends CrudRepository<Assessment, Long> {
    public List<Assessment> findByUserProfileId(long profileId);
}
