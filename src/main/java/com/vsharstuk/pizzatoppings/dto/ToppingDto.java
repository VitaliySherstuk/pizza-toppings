package com.vsharstuk.pizzatoppings.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ToppingDto {

   private Long id;

   @NotBlank
   private String name;
}
