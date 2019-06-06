package com.jackson.demo.jacksonannotations.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.jackson.demo.jacksonannotations.model.UserDetails;
import com.jackson.demo.jacksonannotations.model.UserViews;
import com.jackson.demo.jacksonannotations.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @JsonView(UserViews.ExtendedView.class)
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userService.createUser(userDetails));
    }

    @JsonView(UserViews.BasicView.class)
    @GetMapping("/users/{userId}/basic")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @JsonView(UserViews.ExtendedView.class)
    @GetMapping("/users/{userId}/extended")
    public ResponseEntity<UserDetails> getUserDetailsExtended(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
