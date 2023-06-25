package com.vsharstuk.pizzatoppings.entity

import javax.persistence.*

@Entity
@Table(name = "toppings")
class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null
}
