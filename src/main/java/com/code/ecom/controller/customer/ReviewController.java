package com.code.ecom.controller.customer;

import com.code.ecom.dto.OrderProductsResponseDto;
import com.code.ecom.service.customer.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aoi/custoner")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/ordered-products/{orderId}")
    public ResponseEntity<OrderProductsResponseDto> getOrderedProductsDetailsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(reviewService.getOrderedProductsDetailsByOrderId(orderId));
    }
}
