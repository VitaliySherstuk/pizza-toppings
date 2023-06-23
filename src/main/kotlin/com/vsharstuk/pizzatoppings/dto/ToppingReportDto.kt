package com.vsharstuk.pizzatoppings.dto

import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class ToppingReportDto (val name: String, val count: Long)
    var name: String? = null
    var userCountPerTopping: Long? = null

