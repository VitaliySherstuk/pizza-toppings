package com.vsharstuk.pizzatoppings.dto

import lombok.Data
import javax.validation.constraints.NotBlank

@Data
class ToppingDto {
    var id: Long? = null
    var name: @NotBlank String? = null
}
