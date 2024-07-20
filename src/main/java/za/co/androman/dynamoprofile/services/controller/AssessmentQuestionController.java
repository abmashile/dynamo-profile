package za.co.androman.dynamoprofile.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.AssessmentQuestionService;
import za.co.androman.dynamoprofile.services.controller.integration.AssessmentQuestion;
import za.co.androman.dynamoprofile.services.integration.tranformers.CustomDTOMapper;
import za.co.androman.dynamoprofile.services.integration.tranformers.DTOMapper;

import java.util.Objects;

@RestController
@RequestMapping(value="/question")
public class AssessmentQuestionController {
    private DTOMapper transformer;
    private final AssessmentQuestionService assessmentQuestionService;

    @Autowired
    public AssessmentQuestionController(AssessmentQuestionService assessmentQuestionService,
                                        CustomDTOMapper transformer){
        this.assessmentQuestionService = assessmentQuestionService;
        this.transformer = transformer;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<AssessmentQuestion> getById(@PathVariable("id") long questionId){
        AssessmentQuestion question =  transformer.transform(this.assessmentQuestionService.getById(questionId));
        HttpStatus status = Objects.isNull(question) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<AssessmentQuestion>(question, status);
    }


    @PostMapping(value = "/add")
    public void add(@RequestBody AssessmentQuestion assessmentQuestion){
        this.assessmentQuestionService.add(this.transformer.transform(assessmentQuestion));

    }

    @PostMapping(value = "/update")
    public void update(@RequestBody AssessmentQuestion assessmentQuestion){
        this.assessmentQuestionService.update(this.transformer.transform(assessmentQuestion));

    }

    @PostMapping(value = "/delete")
    public void delete(@RequestBody AssessmentQuestion assessmentQuestion){
        this.assessmentQuestionService.delete(this.transformer.transform(assessmentQuestion));

    }

}
