package com.vsharstuk.pizzatoppings.mapper

import com.vsharstuk.pizzatoppings.dto.ToppingDto
import com.vsharstuk.pizzatoppings.dto.UserDto
import com.vsharstuk.pizzatoppings.entity.Topping
import com.vsharstuk.pizzatoppings.entity.User
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
open class UserMapper {

    fun toUserDto(entity: User?): UserDto?{
        val dto = UserDto()
        dto?.id = entity?.id
        dto.email = entity?.email
        dto.toppings = entity?.toppings?.stream()?.map { topping: Topping? -> ToppingMapper().toToppingDto(topping) }?.collect(Collectors.toList()) as List<ToppingDto>?
        return dto;
    }

    fun toUserEntity(dto: UserDto?): User?{
        val entity = User()
        entity?.id = dto?.id
        entity?.email = dto?.email
        return entity
    }
}
