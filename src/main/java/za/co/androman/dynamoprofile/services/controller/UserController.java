package za.co.androman.dynamoprofile.services.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.androman.dynamoprofile.services.UserService;
import za.co.androman.dynamoprofile.services.controller.integration.User;
import za.co.androman.dynamoprofile.services.integration.tranformers.CustomDTOMapper;
import za.co.androman.dynamoprofile.services.integration.tranformers.DTOMapper;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;
    private DTOMapper transformer;

    @Autowired
    public UserController(UserService userService,
                          CustomDTOMapper transformer) {
        this.userService = userService;
        this.transformer = transformer;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        this.log.info("Adding user {}", user);
        user  = transformer.transform(this.userService.save(transformer.transform(user)));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{userId}")
    public ResponseEntity<User> get(@PathVariable("userId") long userId) {
        this.log.info("getting user with id {}", userId);
        User user = transformer.transform(this.userService.get(userId));
        HttpStatus status = Objects.isNull(user) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<User>(user, status);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        this.log.info("getting all users");
        return transformer.transform(this.userService.getAll());
    }
}