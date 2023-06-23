package com.vsharstuk.pizzatoppings.dto

import lombok.Data
import org.springframework.http.HttpStatus

@Data
class ErrorResponse {
    var status: HttpStatus? = null
    var message: String? = null
    var detail: String? = null
}
