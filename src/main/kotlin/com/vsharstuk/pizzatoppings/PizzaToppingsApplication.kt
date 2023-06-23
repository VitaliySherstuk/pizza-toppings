package com.vsharstuk.pizzatoppings

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PizzaToppingsApplication

fun main(args: Array<String>) {
    runApplication<PizzaToppingsApplication>(*args)
}
