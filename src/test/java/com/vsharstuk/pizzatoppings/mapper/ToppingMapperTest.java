package com.vsharstuk.pizzatoppings.mapper;

import com.vsharstuk.pizzatoppings.dto.ToppingDto;
import com.vsharstuk.pizzatoppings.entity.Topping;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ToppingMapperTest {

    private final ToppingMapper mapper = Mappers.getMapper(ToppingMapper.class);

    @Test
    public void testMappingToppingToDto() {
        //given
        Long toppingId = 123l;
        String toppingName = "test";
        Topping entity = new Topping();
        entity.setId(toppingId);
        entity.setName(toppingName);

        //when
        ToppingDto dto = mapper.toToppingDto(entity);

        //then
        assertEquals(toppingId, dto.getId());
        assertEquals(toppingName, dto.getName());
    }

    @Test
    public void testMappingDtoToTopping() {
        //given
        Long toppingId = 123l;
        String toppingName = "test";
        ToppingDto dto = new ToppingDto();
        dto.setId(toppingId);
        dto.setName(toppingName);

        //when
        Topping entity = mapper.toToppingEntity(dto);

        //then
        assertEquals(toppingId, entity.getId());
        assertEquals(toppingName, entity.getName());
    }

}