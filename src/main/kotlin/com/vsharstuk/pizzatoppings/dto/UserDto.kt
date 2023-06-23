package com.vsharstuk.pizzatoppings.dto

import lombok.Data
import javax.validation.constraints.Pattern

@Data
class UserDto {
    var id: Long? = null
    var email: @Pattern(regexp = EMAIL_PATTERN, message = "Incorrect email format") String? = null
    var toppings: List<ToppingDto>? = null

    companion object {
        private const val EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    }
}
