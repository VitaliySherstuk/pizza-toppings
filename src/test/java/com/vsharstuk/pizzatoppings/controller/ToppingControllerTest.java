package com.vsharstuk.pizzatoppings.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vsharstuk.pizzatoppings.dto.CustomerToppingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ToppingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddToppings_whenCorrectInputData_thenReturnStatusOk() throws Exception {
        //given
        CustomerToppingDto toppingDto = new CustomerToppingDto();
        toppingDto.setEmail("test@gmail.com");
        toppingDto.setToppings(Arrays.asList("cheese", "chicken", "oliva"));

        //when
        MockHttpServletResponse response = mockMvc.perform(post("/toppings")
                        .content(objectMapper.writeValueAsString(toppingDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse();

        //then
        assertEquals(toppingDto.toString(), response.getContentAsString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "test.com", "test.c", "---@.gmail"})
    public void testAddToppings_whenIncorrectEmailFormat_thenReturnBadRequest(String email) throws Exception {
        //given
        CustomerToppingDto toppingDto = new CustomerToppingDto();
        toppingDto.setEmail(email);
        toppingDto.setToppings(Arrays.asList("cheese", "chicken", "oliva"));

        //when
        mockMvc.perform(post("/toppings")
                        .content(objectMapper.writeValueAsString(toppingDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}