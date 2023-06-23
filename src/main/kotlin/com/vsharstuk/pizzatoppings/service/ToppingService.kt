package com.vsharstuk.pizzatoppings.service

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto
import com.vsharstuk.pizzatoppings.entity.Topping
import com.vsharstuk.pizzatoppings.repository.ToppingRepository
import com.vsharstuk.pizzatoppings.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@RequiredArgsConstructor
open class ToppingService {
    private val toppingRepository: ToppingRepository? = null
    private val userRepository: UserRepository? = null
    @Transactional
    fun create(toppings: List<Topping?>) {
        toppings.forEach { topping ->
            val toppingName = topping?.name
            toppingName?.let { toppingRepository?.saveOrUpdate(it) }
        }
    }

    fun findAllToppingByName(names: List<String?>?): List<Topping?>? {
        return toppingRepository!!.findAllByNameIn(names)
    }

    fun countUsersPerToppings(pageable: Pageable?): Page<ToppingReportDto?>? {
        return userRepository!!.countUsersPerTopping(pageable)
    }
}
