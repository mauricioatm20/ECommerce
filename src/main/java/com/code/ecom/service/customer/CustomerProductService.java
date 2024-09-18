package com.code.ecom.service.customer;

import com.code.ecom.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> searchProductByTitle(String title);

    List<ProductDto> getAllProducts();
}
