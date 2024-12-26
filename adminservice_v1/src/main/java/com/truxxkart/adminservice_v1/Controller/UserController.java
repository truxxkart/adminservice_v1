package com.truxxkart.adminservice_v1.Controller;

import com.truxxkart.adminservice_v1.dto.Userdto;
import com.truxxkart.adminservice_v1.feignclient.userService.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

import static java.util.logging.Level.INFO;

@Slf4j
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("/createuser")
    public ResponseEntity<Userdto> createUser(@RequestBody Userdto user){
        log(INFO,"Calling the UserService");
//        log("Calling the UserSeervice");
//        setLogLevel("Calling the UserService");
        ResponseEntity<Userdto> createuser =userFeign.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(createuser.getBody());
    }

    private void log(Level info, String s) {
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<Userdto>> getAllUser(){
        log(INFO,"Calling the UserService");
        ResponseEntity<List<Userdto>> allUsers = userFeign.getAllUser();
        return allUsers;
    }
    @GetMapping("/getuser/{id}")
    public ResponseEntity<Userdto> getUserById(@PathVariable Long id){
        log(INFO,"Calling the UserService");
        ResponseEntity<Userdto> getUser = userFeign.getUsersById(id);
        return getUser;
    }




}
