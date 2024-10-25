package com.code.ecom.service.auth;

import com.code.ecom.dto.SignupRequest;
import com.code.ecom.dto.UserDto;
import com.code.ecom.entity.Order;
import com.code.ecom.entity.User;
import com.code.ecom.enums.OrderStatus;
import com.code.ecom.enums.UserRole;
import com.code.ecom.repository.OrderRepository;
import com.code.ecom.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private OrderRepository orderRepository;

    public UserDto createUser(SignupRequest signupRequest){

        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        //user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);

        Order order = new Order();
        order.setAmount(0L);
        order.setTotalAmount(0L);
        order.setDiscount(0L);
        order.setUser(createdUser);
        order.setOrderStatus(OrderStatus.Pending);
        orderRepository.save(order);

        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }

    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (null == adminAccount){
            User user = new User();

            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            //user.setPassword(bCryptPasswordEncoder.encode("admin"));
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));

            userRepository.save(user);
        }
    }
}
