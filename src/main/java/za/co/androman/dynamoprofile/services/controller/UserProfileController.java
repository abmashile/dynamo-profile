package za.co.androman.dynamoprofile.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.UserProfileService;
import za.co.androman.dynamoprofile.services.controller.integration.UserProfile;
import za.co.androman.dynamoprofile.services.integration.tranformers.CustomDTOMapper;
import za.co.androman.dynamoprofile.services.integration.tranformers.DTOMapper;

@RestController
@RequestMapping(path = "/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final DTOMapper mapper;

    @Autowired
    public UserProfileController(UserProfileService userProfileService,
                                 CustomDTOMapper mapper){
        this.userProfileService = userProfileService;
        this.mapper = mapper;
    }
    @PostMapping(path = "/add")
    public ResponseEntity<UserProfile> add(@RequestBody UserProfile userProfile){
        UserProfile profile = mapper.transform(this.userProfileService.add(mapper.transform(userProfile)));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(profile, HttpStatus.OK );
    }

    @GetMapping(path = "/update")
    public ResponseEntity<UserProfile> update(@RequestBody UserProfile userProfile){
        UserProfile profile = mapper.transform(this.userProfileService.update(mapper.transform(userProfile)));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(profile, HttpStatus.OK );
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<UserProfile> delete(@RequestBody UserProfile userProfile){
        this.userProfileService.delete(mapper.transform(userProfile));
        return new ResponseEntity<>(userProfile, HttpStatus.OK );
    }


    @GetMapping(path = "/get/{profileId}")
    public ResponseEntity<UserProfile> get(@PathVariable("profileId") Long profileId){
        UserProfile userProfile = mapper.transform(this.userProfileService.find(profileId));
        return new ResponseEntity<>(userProfile, HttpStatus.OK );
    }
}
