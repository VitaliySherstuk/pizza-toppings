package com.vsharstuk.pizzatoppings.dto

import lombok.Data
import javax.validation.Valid

@Data
class UserToppingRequest {
    var toppings: @Valid MutableList<ToppingDto>? = null
}
