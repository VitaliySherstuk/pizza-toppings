package com.vsharstuk.pizzatoppings.dto

import lombok.Data

@Data
class ToppingReportDto (val name: String, val count: Long)
    var name: String? = null
    var userCountPerTopping: Long? = null

