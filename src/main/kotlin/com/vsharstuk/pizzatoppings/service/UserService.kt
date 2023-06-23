package com.vsharstuk.pizzatoppings.service

import com.vsharstuk.pizzatoppings.entity.Topping
import com.vsharstuk.pizzatoppings.entity.User
import com.vsharstuk.pizzatoppings.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@RequiredArgsConstructor
open class UserService {
    private val userRepository: UserRepository? = null
    private val toppingService: ToppingService? = null
    @Transactional
    fun submit(userId: Long, toppings: List<Topping?>) {
        val user = userRepository!!.getById(userId)
        toppingService!!.create(toppings)
        val updatedToppings = toppingService.findAllToppingByName(toppings.map { it?.name })
        user!!.toppings = updatedToppings as List<Topping>?
        userRepository.save(user)
    }

    fun getUser(userId: Long): User {
        return userRepository!!.getById(userId)!!
    }

    fun create(user: User): User {
        return userRepository!!.save(user)
    }
}
