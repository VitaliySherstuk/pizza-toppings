package com.vsharstuk.pizzatoppings.controller

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto
import com.vsharstuk.pizzatoppings.service.ToppingService
import com.vsharstuk.pizzatoppings.util.PageableUtils.of
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/report/toppings")
class ToppingReportController {

    @Autowired
    private lateinit var toppingService: ToppingService

    @GetMapping
    fun generateReport(@RequestParam(name = "page_number", required = false, defaultValue = "1") pageNumber: Int?,
                       @RequestParam(name = "page_size", required = false, defaultValue = "2") pageSize: Int?,
                       @RequestParam(name = "sort", required = false) sort: String): Page<ToppingReportDto?>? {
        return toppingService?.countUsersPerToppings(of(pageNumber!!, pageSize!!, sort, "amount"))
    }
}
