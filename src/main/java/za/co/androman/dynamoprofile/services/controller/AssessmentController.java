package za.co.androman.dynamoprofile.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.AssessmentService;
import za.co.androman.dynamoprofile.services.controller.integration.Assessment;
import za.co.androman.dynamoprofile.services.controller.integration.ServiceResponse;
import za.co.androman.dynamoprofile.services.integration.tranformers.DefaultTransformer;

@RestController
@RequestMapping(path = "/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;
    private final DefaultTransformer transformer;
    @Autowired
    public AssessmentController(AssessmentService assessmentService,
                                DefaultTransformer transformer){
        this.assessmentService = assessmentService;
        this.transformer = transformer;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<ServiceResponse> add(@RequestBody Assessment assessment){
        this.assessmentService.add(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }

    @GetMapping(path = "/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Assessment assessment){
        this.assessmentService.update(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<ServiceResponse> delete(@RequestBody Assessment assessment){
        this.assessmentService.delete(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }
}
