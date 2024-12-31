package com.truxxkart.adminservice_v1.feignclient.userService;

import com.truxxkart.adminservice_v1.dto.Cart;
import com.truxxkart.adminservice_v1.dto.CartItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "userserviceCart", url = "http://localhost:8010/cart")
public interface CartFeign {
    @GetMapping
    public Cart getCart(@RequestParam(required = false) Long userId) ;

    @PostMapping("/{cartId}/item")
    public Cart addItem(@PathVariable String cartId, @RequestBody CartItemDto cartItemDto) ;

    @PutMapping("/increment/{cartId}/item/{itemId}")
    public Cart incrementItemQuantity(@PathVariable String cartId, @PathVariable String itemId);
    @PutMapping("/decrement/{cartId}/item/{itemId}")
    public Cart decrementItemQuantity(@PathVariable String cartId, @PathVariable String itemId) ;

    @DeleteMapping("/{cartId}/item/{itemId}")
    public Cart removeItem(@PathVariable String cartId, @PathVariable String itemId) ;

}
