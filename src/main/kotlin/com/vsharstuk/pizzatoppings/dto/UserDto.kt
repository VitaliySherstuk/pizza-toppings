package com.vsharstuk.pizzatoppings.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class UserDto {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Long id;
    @Pattern(regexp = EMAIL_PATTERN, message = "Incorrect email format")
    private String email;
    private List<ToppingDto> toppings;
}
