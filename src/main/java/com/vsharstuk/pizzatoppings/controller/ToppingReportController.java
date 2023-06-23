package com.vsharstuk.pizzatoppings.controller;

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto;
import com.vsharstuk.pizzatoppings.service.ToppingService;
import com.vsharstuk.pizzatoppings.util.PageableUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report/toppings")
@RequiredArgsConstructor
public class ToppingReportController {

    private final ToppingService toppingService;

    @GetMapping
    public Page<ToppingReportDto> generateReport (@RequestParam(name = "page_number", required = false, defaultValue = "1") Integer pageNumber,
                                                  @RequestParam(name = "page_size", required = false, defaultValue = "2") Integer pageSize,
                                                  @RequestParam(name = "sort", required = false) String sort) {
        return toppingService.countUsersPerToppings(PageableUtils.of(pageNumber, pageSize, sort, "amount"));
    }
}
