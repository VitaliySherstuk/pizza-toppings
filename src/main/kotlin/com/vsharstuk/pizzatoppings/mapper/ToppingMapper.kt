package com.vsharstuk.pizzatoppings.mapper

import com.vsharstuk.pizzatoppings.dto.ToppingDto
import com.vsharstuk.pizzatoppings.entity.Topping
import org.springframework.stereotype.Component


@Component
open class ToppingMapper {

    fun toToppingDto(entity: Topping?): ToppingDto?{
        val dto = ToppingDto()
        dto.id = entity?.id
        dto.name = entity?.name
        return dto
    }

    fun toToppingEntity(dto: ToppingDto?): Topping?{
        val entity = Topping()
        entity.id = dto?.id
        entity.name = dto?.name
        return entity
    }
}
