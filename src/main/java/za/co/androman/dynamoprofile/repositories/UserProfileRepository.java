package za.co.androman.dynamoprofile.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.androman.dynamoprofile.entities.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
}
