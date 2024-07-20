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
    public ResponseEntity<ServiceResponse> add(@RequestBody Assessment assessment){
        this.assessmentService.add(mappper.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }

    @GetMapping(path = "/get/{assessmentId}")
    public ResponseEntity<Assessment> update(@PathVariable("assessmentId") Long assessmentId){
        Assessment assessment = this.mappper.transform(this.assessmentService.findById(assessmentId));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(assessment, status);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<ServiceResponse> delete(@RequestBody Assessment assessment){
        this.assessmentService.delete(mappper.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }
}
