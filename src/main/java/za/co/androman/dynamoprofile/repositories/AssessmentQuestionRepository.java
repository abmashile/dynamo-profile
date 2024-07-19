package za.co.androman.dynamoprofile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.androman.dynamoprofile.entities.AssessmentQuestion;

public interface AssessmentQuestionRepository extends JpaRepository<AssessmentQuestion, Long> {
}
