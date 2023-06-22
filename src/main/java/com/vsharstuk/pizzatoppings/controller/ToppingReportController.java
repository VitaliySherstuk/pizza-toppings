package com.vsharstuk.pizzatoppings.controller;

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto;
import com.vsharstuk.pizzatoppings.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report/toppings")
@RequiredArgsConstructor
public class ToppingReportController {

    private final ToppingService toppingService;

    @GetMapping
    public List<ToppingReportDto> generateReport () {
        return toppingService.countUsersPerToppings();
    }
}
