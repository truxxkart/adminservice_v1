package com.truxxkart.adminservice_v1.Controller;

import com.truxxkart.adminservice_v1.dto.Cart;
import com.truxxkart.adminservice_v1.dto.CartItemDto;
import com.truxxkart.adminservice_v1.feignclient.userService.CartFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CartController {

    @Autowired
    CartFeign cartFeign;

    @GetMapping("/{userId}")
    public Cart getCart(@RequestParam(required = false) Long userId) {
        return cartFeign.getCart(userId);
    }

    @PostMapping("/{cartId}/item")
    public Cart addItem(@PathVariable String cartId, @RequestBody CartItemDto cartItemDto) {
          return cartFeign.addItem(cartId,cartItemDto);
    }

    @PutMapping("/increment/{cartId}/item/{itemId}")
    public Cart incrementItemQuantity(@PathVariable String cartId, @PathVariable String itemId) {
//        Cart cart = cartService.getCartById(cartId);
//        return cartService.incrementItemFromCart(cart, itemId);
        return cartFeign.incrementItemQuantity(cartId,itemId);
    }
    @PutMapping("/decrement/{cartId}/item/{itemId}")
    public Cart decrementItemQuantity(@PathVariable String cartId, @PathVariable String itemId) {
//        Cart cart = cartService.getCartById(cartId);
//        return cartService.decrementItemFromCart(cart, itemId);
        return cartFeign.decrementItemQuantity(cartId,itemId);
    }

    @DeleteMapping("/{cartId}/item/{itemId}")
    public Cart removeItem(@PathVariable String cartId, @PathVariable String itemId) {
//        Cart cart = cartService.getCartById(cartId);
//        return cartService.removeItemFromCart(cart, itemId);
        return cartFeign.removeItem(cartId,itemId);
    }
}
