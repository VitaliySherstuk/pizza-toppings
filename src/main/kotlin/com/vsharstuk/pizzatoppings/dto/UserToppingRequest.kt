package com.vsharstuk.pizzatoppings.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class UserToppingRequest {

    @Valid
    private List<ToppingDto> toppings;
}
