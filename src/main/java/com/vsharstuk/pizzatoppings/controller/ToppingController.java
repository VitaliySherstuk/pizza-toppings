package com.vsharstuk.pizzatoppings.controller;

import com.vsharstuk.pizzatoppings.dto.CustomerToppingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/toppings")
@RequiredArgsConstructor
public class ToppingController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void submitToppings(@RequestBody @Valid CustomerToppingDto customerToppingDto) {

    }
}
