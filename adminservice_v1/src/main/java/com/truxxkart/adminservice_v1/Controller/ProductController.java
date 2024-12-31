package com.truxxkart.adminservice_v1.Controller;

import com.truxxkart.adminservice_v1.dto.Product;
import com.truxxkart.adminservice_v1.feignclient.userService.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductFeign productFeign;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> proList =productFeign.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(proList.getBody());

    }
}
