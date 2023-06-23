package com.vsharstuk.pizzatoppings.mapper

import com.vsharstuk.pizzatoppings.dto.ToppingDto
import com.vsharstuk.pizzatoppings.entity.Topping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
interface ToppingMapper {
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    fun toToppingDto(entity: Topping?): ToppingDto?
    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    fun toToppingEntity(dto: ToppingDto?): Topping?
}
