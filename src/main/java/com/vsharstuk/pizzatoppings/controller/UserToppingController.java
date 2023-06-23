package com.vsharstuk.pizzatoppings.controller;

import com.vsharstuk.pizzatoppings.dto.UserDto;
import com.vsharstuk.pizzatoppings.dto.UserToppingRequest;
import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.entity.User;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserToppingController {

    private final UserService userService;
    private final ToppingMapper toppingMapper;
    private final UserMapper userMapper;

    @PostMapping("/{user_id}/toppings")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitToppings(@PathVariable("user_id") Long userIid,
                               @RequestBody @Valid UserToppingRequest request) {

        List<Topping> toppings = request.getToppings().stream().map(toppingMapper::toToppingEntity).collect(Collectors.toList());
        userService.submit(userIid, toppings);
    }

    @GetMapping("/{user_id}")
    public UserDto getUser(@PathVariable("user_id") Long userId) {
        return userMapper.toUserDto(userService.getUser(userId));
    }

    @PostMapping
    public UserDto create(@RequestBody @Valid UserDto userDto) {
        User user = userService.create(userMapper.toUserEntity(userDto));
        return userMapper.toUserDto(user);
    }
}
