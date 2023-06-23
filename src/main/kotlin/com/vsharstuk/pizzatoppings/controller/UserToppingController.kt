package com.vsharstuk.pizzatoppings.controller

import com.vsharstuk.pizzatoppings.dto.ToppingDto
import com.vsharstuk.pizzatoppings.dto.UserDto
import com.vsharstuk.pizzatoppings.dto.UserToppingRequest
import com.vsharstuk.pizzatoppings.mapper.ToppingMapper
import com.vsharstuk.pizzatoppings.mapper.UserMapper
import com.vsharstuk.pizzatoppings.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserToppingController {
    private val userService: UserService? = null
    private val toppingMapper: ToppingMapper? = null
    private val userMapper: UserMapper? = null
    @PostMapping("/{user_id}/toppings")
    @ResponseStatus(HttpStatus.CREATED)
    fun submitToppings(@PathVariable("user_id") userIid: Long?,
                       @RequestBody request: @Valid UserToppingRequest?) {
        val toppings = request!!.toppings!!.stream().map { dto: ToppingDto? -> toppingMapper!!.toToppingEntity(dto) }.collect(Collectors.toList())
        userService!!.submit(userIid!!, toppings)
    }

    @GetMapping("/{user_id}")
    fun getUser(@PathVariable("user_id") userId: Long?): UserDto? {
        return userMapper!!.toUserDto(userService!!.getUser(userId!!))
    }

    @PostMapping
    fun create(@RequestBody userDto: @Valid UserDto?): UserDto? {
        val user = userService!!.create(userMapper!!.toUserEntity(userDto)!!)
        return userMapper.toUserDto(user)
    }
}
