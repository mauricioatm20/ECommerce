package com.code.ecom.service.customer.wishlist;

import com.code.ecom.dto.ProductDetailDto;
import com.code.ecom.dto.WishlistDto;
import com.code.ecom.entity.Product;
import com.code.ecom.entity.User;
import com.code.ecom.entity.Wishlist;
import com.code.ecom.repository.ProductRepository;
import com.code.ecom.repository.UserRepository;
import com.code.ecom.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;


    public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
        Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());

        if( optionalProduct.isPresent()  && optionalUser.isPresent() ){
            Wishlist wishlist = new Wishlist();

            wishlist.setProduct(optionalProduct.get());
            wishlist.setUser(optionalUser.get());

            return wishlistRepository.save(wishlist).getWishlistDto();
        }
        return null;
    }

    public List<WishlistDto> getWishlistByUserId(Long userId) {
        return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
    }
}
