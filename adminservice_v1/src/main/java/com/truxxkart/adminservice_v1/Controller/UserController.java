package com.truxxkart.adminservice_v1.Controller;

import com.truxxkart.adminservice_v1.dto.User;
import com.truxxkart.adminservice_v1.feignclient.userService.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

import static java.util.logging.Level.INFO;
import static org.hibernate.internal.CoreLogging.logger;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log(INFO,"Calling the UserService");
        logger("Calling the UserServicw_v1");
//        log("Calling the UserSeervice");
//        setLogLevel("Calling the UserService");
        ResponseEntity<User> createuser =userFeign.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(createuser.getBody());
    }

    private void log(Level info, String s) {
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUser(){
        log(INFO,"Calling the UserService");
        logger("Calling the UserServicw_v1");
        ResponseEntity<List<User>> allUsers = userFeign.getAllUser();
        return allUsers;
    }
    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        log(INFO,"Calling the UserService");
        logger("Calling the UserServicw_v1");
        ResponseEntity<User> getUser = userFeign.getUsersById(id);
        return getUser;
    }




}
