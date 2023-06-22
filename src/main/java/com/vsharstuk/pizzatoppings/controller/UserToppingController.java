package com.vsharstuk.pizzatoppings.controller;

import com.vsharstuk.pizzatoppings.dto.ToppingDto;
import com.vsharstuk.pizzatoppings.dto.UserDto;
import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.mapper.ToppingMapper;
import com.vsharstuk.pizzatoppings.mapper.UserMapper;
import com.vsharstuk.pizzatoppings.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/{user_id}")
@RequiredArgsConstructor
public class UserToppingController {

    private final UserService userService;
    private final ToppingMapper toppingMapper;
    private final UserMapper userMapper;

    @PostMapping("/toppings")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitToppings(@PathVariable("user_id") Long userIid,
                               @RequestBody List<ToppingDto> request) {

        List<Topping> toppings = request.stream().map(toppingMapper::toToppingEntity).collect(Collectors.toList());
        userService.submit(userIid, toppings);
    }

    @GetMapping
    public UserDto getUser(@PathVariable("user_id") Long userId) {
        return userMapper.toUserDto(userService.getUser(userId));
    }
}