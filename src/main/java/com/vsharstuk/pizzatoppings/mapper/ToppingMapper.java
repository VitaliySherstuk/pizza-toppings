package com.vsharstuk.pizzatoppings.mapper;

import com.vsharstuk.pizzatoppings.dto.ToppingDto;
import com.vsharstuk.pizzatoppings.entity.Topping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ToppingMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ToppingDto toToppingDto(Topping entity);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "users", ignore = true)
    Topping toToppingEntity(ToppingDto dto);
}
