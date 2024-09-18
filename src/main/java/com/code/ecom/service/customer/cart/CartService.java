package com.code.ecom.service.customer.cart;

import com.code.ecom.dto.AddProductInCartDto;
import com.code.ecom.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);
}
