package com.vsharstuk.pizzatoppings.mapper;

import com.vsharstuk.pizzatoppings.dto.UserDto;
import com.vsharstuk.pizzatoppings.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {ToppingMapper.class}, unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class UserMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "email", source = "entity.email")
    @IterableMapping(qualifiedByName = "toToppingDto")
    public abstract UserDto toUserDto(User entity);


    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "toppings", ignore = true)
    public abstract User toUserEntity(UserDto dto);
}
