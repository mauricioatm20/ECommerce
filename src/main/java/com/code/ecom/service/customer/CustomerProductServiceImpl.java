package com.code.ecom.service.customer;

import com.code.ecom.dto.ProductDto;
import com.code.ecom.entity.Product;
import com.code.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product:: getDto).collect(Collectors.toList());
    }

    public List<ProductDto> searchProductByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product:: getDto).collect(Collectors.toList());
    }
}
