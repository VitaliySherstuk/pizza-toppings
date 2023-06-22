package com.vsharstuk.pizzatoppings.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsharstuk.pizzatoppings.dto.ToppingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserToppingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddToppings_whenIncorrectEmailFormat_thenReturnBadRequest() throws Exception {
        //given
        ToppingDto toppingDto = new ToppingDto();
        toppingDto.setName("cheese");

        //when
        mockMvc.perform(post("/users/1/toppings")
                        .content(objectMapper.writeValueAsString(Arrays.asList(toppingDto)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}