package za.co.androman.dynamoprofile.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.androman.dynamoprofile.entities.AssessmentQuestion;
import za.co.androman.dynamoprofile.repositories.AssessmentQuestionRepository;
import java.util.List;

@Service
public class AssessmentQuestionService {

    private final AssessmentQuestionRepository assessmentQuestionRepository;
    @Autowired
    public AssessmentQuestionService(AssessmentQuestionRepository assessmentQuestionRepository){
        this.assessmentQuestionRepository = assessmentQuestionRepository;
    }

    public AssessmentQuestion getById(long id){
        return this.assessmentQuestionRepository.findById(id).orElse(null);
    }

    public List<AssessmentQuestion> findByAssessmentId(){
        return this.assessmentQuestionRepository.findAll();
    }

    public AssessmentQuestion add(AssessmentQuestion question){
        return this.assessmentQuestionRepository.save(question);
    }
    public AssessmentQuestion update(AssessmentQuestion question){
        AssessmentQuestion savedInstance = this.assessmentQuestionRepository.save(question);
        return savedInstance;
    }
    public AssessmentQuestion delete(AssessmentQuestion question){
        return this.assessmentQuestionRepository.save(question);
    }
}
