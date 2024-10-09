package com.code.ecom.service.customer.review;

import com.code.ecom.dto.OrderProductsResponseDto;

public interface ReviewService {

    OrderProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
}
