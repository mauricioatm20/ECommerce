package com.code.ecom.service.customer.review;

import com.code.ecom.dto.OrderedProductsResponseDto;
import com.code.ecom.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {

    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
