package za.co.androman.dynamoprofile.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.AssessmentService;
import za.co.androman.dynamoprofile.services.controller.integration.Assessment;
import za.co.androman.dynamoprofile.services.integration.tranformers.CustomDTOMapper;
import za.co.androman.dynamoprofile.services.integration.tranformers.DTOMapper;

@RestController
@RequestMapping(path = "/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;
    private final DTOMapper mappper;
    @Autowired
    public AssessmentController(AssessmentService assessmentService,
                                CustomDTOMapper mappper){
        this.assessmentService = assessmentService;
        this.mappper = mappper;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Assessment> add(@RequestBody Assessment assessment){
        assessment = mappper.transform(this.assessmentService.add(mappper.transform(assessment)));
        return new ResponseEntity<>(assessment, HttpStatus.OK );
    }

    @GetMapping(path = "/get/{assessmentId}")
    public ResponseEntity<Assessment> update(@PathVariable("assessmentId") Long assessmentId){
        Assessment assessment = this.mappper.transform(this.assessmentService.findById(assessmentId));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(assessment, status);
    }

    @PostMapping(path = "/delete")
    public void delete(@RequestBody Assessment assessment){
        this.assessmentService.delete(mappper.transform(assessment));
    }
}
