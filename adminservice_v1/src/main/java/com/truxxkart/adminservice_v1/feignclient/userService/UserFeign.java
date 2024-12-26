package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.Userdto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name = "user-service",url = "http://localhost:8010")
//public interface UserFeign {
//    @PostMapping()
//    public ResponseEntity<Userdto> createUser(@RequestBody Userdto user);
//
//    @GetMapping()
//    public ResponseEntity<List<Userdto>> getAllUser();
//
//
//    @GetMapping("/id/{id}")
//    public ResponseEntity<Userdto> getUsersById(@PathVariable Long id);
//
//}
@FeignClient(name = "user-service", url = "http://localhost:8010")
public interface UserFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<Userdto> createUser(@RequestBody Userdto user);

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<Userdto>> getAllUser();

    @RequestMapping(method = RequestMethod.GET, value = "/users/id/{id}")
    public ResponseEntity<Userdto> getUsersById(@PathVariable Long id);
}
