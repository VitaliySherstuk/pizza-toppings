package com.vsharstuk.pizzatoppings.repository

import com.vsharstuk.pizzatoppings.entity.Topping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ToppingRepository : JpaRepository<Topping?, Long?> {
    @Modifying
    @Query(value = "insert into toppings(name) values(:name) on conflict do nothing", nativeQuery = true)
    fun saveOrUpdate(@Param("name") toppingName: String?)
    fun findAllByNameIn(names: List<String?>?): List<Topping?>?
}
