package com.vsharstuk.pizzatoppings.entity

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "email")
    var email: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "user_topping", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "topping_id")])
    var toppings: List<Topping>? = null
}
