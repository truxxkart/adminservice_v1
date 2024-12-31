package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8010")
public interface UserFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getAllUser();

    @RequestMapping(method = RequestMethod.GET, value = "/users/id/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable Long id);
}
