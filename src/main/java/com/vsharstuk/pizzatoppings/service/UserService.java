package com.vsharstuk.pizzatoppings.service;

import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.entity.User;
import com.vsharstuk.pizzatoppings.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ToppingService toppingService;

    @Transactional
    public void submit(Long userId, List<Topping> toppings) {
        User user = userRepository.getById(userId);
        toppingService.create(toppings);
        List<Topping> updatedToppings = toppingService.findAllToppingByName(
                toppings.stream()
                        .map(Topping::getName)
                        .collect(Collectors.toList()));
        user.setToppings(updatedToppings);
        userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.getById(userId);
    }
}
