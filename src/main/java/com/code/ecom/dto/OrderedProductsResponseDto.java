package com.code.ecom.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderProductsResponseDto {

    private List<ProductDto> productDtoList;

    private Long orderAmount;
}
