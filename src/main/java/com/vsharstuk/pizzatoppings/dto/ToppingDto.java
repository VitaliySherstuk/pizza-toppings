package com.vsharstuk.pizzatoppings.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ToppingDto {


   private Long id;
   @NotNull
   private String name;
}
