package com.code.ecom.service.customer.cart;

import com.code.ecom.dto.AddProductInCartDto;
import com.code.ecom.dto.CartItemsDto;
import com.code.ecom.dto.OrderDto;
import com.code.ecom.entity.CartItems;
import com.code.ecom.entity.Order;
import com.code.ecom.entity.Product;
import com.code.ecom.entity.User;
import com.code.ecom.enums.OrderStatus;
import com.code.ecom.repository.CartItemsRepository;
import com.code.ecom.repository.OrderRepository;
import com.code.ecom.repository.ProductRepository;
import com.code.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto) {
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);


        Optional<CartItems> optionalCartItems = cartItemsRepository.findByProductIdAndOrderIdAndUserId(addProductInCartDto.getProductId(), activeOrder.getId(),addProductInCartDto.getUserId());

        if(optionalCartItems.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }else {
            Optional<Product> optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
            Optional<User> optionalUser = userRepository.findById(addProductInCartDto.getUserId());

            if(optionalProduct.isPresent() && optionalUser.isPresent()){
                CartItems cart = new CartItems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);

                CartItems updatedCart = cartItemsRepository.save(cart);

                activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount() + cart.getPrice());
                activeOrder.getCartItems().add(cart);

                orderRepository.save(activeOrder);
                return ResponseEntity.status(HttpStatus.CREATED).body(cart.getId());

            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not foud");
            }
        }
    }

    public OrderDto getCartByUserId(Long userId) {
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.Pending);
        List<CartItemsDto> cartItemsDtoList = activeOrder.getCartItems().stream().map(CartItems::getCartDto).collect(Collectors.toList());

        OrderDto orderDto = new OrderDto();

        orderDto.setAmount(activeOrder.getAmount());
        orderDto.setId(activeOrder.getId());
        orderDto.setOrderStatus(activeOrder.getOrderStatus());
        orderDto.setDiscount(activeOrder.getDiscount());
        orderDto.setTotalAmount(activeOrder.getTotalAmount());
        orderDto.setCartItems(cartItemsDtoList);

        return orderDto;
    }
}
