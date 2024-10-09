package com.code.ecom.service.admin.adminproduct;

import com.code.ecom.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {

    ProductDto addProduct(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductByName(String name);

    boolean deleteProduct(Long id);

    ProductDto getProductById(Long productId);

    ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;
}
