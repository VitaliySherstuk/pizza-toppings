package com.vsharstuk.pizzatoppings.controller

import com.vsharstuk.pizzatoppings.dto.ToppingDto
import com.vsharstuk.pizzatoppings.dto.UserDto
import com.vsharstuk.pizzatoppings.dto.UserToppingRequest
import com.vsharstuk.pizzatoppings.mapper.ToppingMapper
import com.vsharstuk.pizzatoppings.mapper.UserMapper
import com.vsharstuk.pizzatoppings.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserToppingController {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var toppingMapper: ToppingMapper
    @Autowired
    lateinit var userMapper: UserMapper

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
