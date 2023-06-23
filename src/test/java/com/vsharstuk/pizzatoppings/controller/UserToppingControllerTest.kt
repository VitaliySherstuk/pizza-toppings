package com.vsharstuk.pizzatoppings.controller

import com.fasterxml.jackson.databind.ObjectMapper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class UserToppingControllerTest {
    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val objectMapper: ObjectMapper? = null
    /*@Test
    @Throws(Exception::class)
    fun testAddToppings_whenIncorrectEmailFormat_thenReturnBadRequest() {
        //given
        val toppingDto = ToppingDto()
        toppingDto.setName("cheese")

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/toppings")
                .content(objectMapper.writeValueAsString(Arrays.asList<Any>(toppingDto)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
    }*/
}