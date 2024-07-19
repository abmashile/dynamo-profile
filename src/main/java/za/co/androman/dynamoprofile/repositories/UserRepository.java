package za.co.androman.dynamoprofile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.androman.dynamoprofile.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
