package com.code.ecom.service.customer.review;

import com.code.ecom.dto.OrderProductsResponseDto;
import com.code.ecom.dto.ProductDto;
import com.code.ecom.entity.CartItems;
import com.code.ecom.entity.Order;
import com.code.ecom.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final OrderRepository orderRepository;

    public OrderProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        OrderProductsResponseDto orderProductsResponseDto = new OrderProductsResponseDto();
        if (optionalOrder.isPresent()) {
            orderProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

            List<ProductDto> productDtoList = new ArrayList<>();
            for (CartItems cartItems : optionalOrder.get().getCartItems()) {
                ProductDto productDto = new ProductDto();

                productDto.setId(cartItems.getProduct().getId());
                productDto.setName(cartItems.getProduct().getName());
                productDto.setPrice(cartItems.getProduct().getPrice());
                productDto.setQuantity(cartItems.getQuantity());

                productDto.setByteImg(cartItems.getProduct().getImg());

                productDtoList.add(productDto);
            }
            orderProductsResponseDto.setProductDtoList(productDtoList);
        }
        return orderProductsResponseDto;
    }
}
