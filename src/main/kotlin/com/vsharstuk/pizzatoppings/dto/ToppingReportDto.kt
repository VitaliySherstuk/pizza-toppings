package com.vsharstuk.pizzatoppings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToppingReportDto {

    private String name;
    private Long userCountPerTopping;
}
