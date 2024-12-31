package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "sellerservice" , url = "http://localhost:8000")
public interface ProductFeign {
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts();
}
