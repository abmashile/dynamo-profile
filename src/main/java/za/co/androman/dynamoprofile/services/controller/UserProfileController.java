package za.co.androman.dynamoprofile.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.UserProfileService;
import za.co.androman.dynamoprofile.services.controller.integration.ServiceResponse;
import za.co.androman.dynamoprofile.services.controller.integration.UserProfile;
import za.co.androman.dynamoprofile.services.integration.tranformers.DefaultTransformer;

@RestController
@RequestMapping(path = "/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final DefaultTransformer transformer;
    @Autowired
    public UserProfileController(UserProfileService userProfileService,
                                 DefaultTransformer transformer){
        this.userProfileService = userProfileService;
        this.transformer = transformer;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<ServiceResponse> add(@RequestBody UserProfile assessment){
        this.userProfileService.add(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }

    @GetMapping(path = "/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody UserProfile assessment){
        this.userProfileService.update(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<ServiceResponse> delete(@RequestBody UserProfile assessment){
        this.userProfileService.delete(transformer.transform(assessment));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK );
    }


    @GetMapping(path = "/{profileId}")
    public ResponseEntity<UserProfile> get(@PathVariable("profileId") Long profileId){
        UserProfile userProfile = transformer.transform(this.userProfileService.find(profileId));
        ServiceResponse serviceResponse = new ServiceResponse();
        HttpStatus status = HttpStatus.OK;
        serviceResponse.setStatus(status);
        return new ResponseEntity<>(userProfile, HttpStatus.OK );
    }
}
