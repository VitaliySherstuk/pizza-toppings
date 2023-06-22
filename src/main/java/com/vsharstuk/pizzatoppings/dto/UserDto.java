package com.vsharstuk.pizzatoppings.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String email;
    private List<ToppingDto> toppings;
}
