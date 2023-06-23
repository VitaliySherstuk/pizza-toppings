package com.vsharstuk.pizzatoppings.util;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageableUtilsTest {

    @Test
    public void testGetDirection_whenSortIsASC_thenReturnASC() {
        String sort = "aSc";
        Sort.Direction result = PageableUtils.getDirection(sort);
        assertEquals(Sort.Direction.ASC, result);
    }

    @Test
    public void testGetDirection_whenSortIsDESC_thenReturnDESC() {
        String sort = "DeSc";
        Sort.Direction result = PageableUtils.getDirection(sort);
        assertEquals(Sort.Direction.DESC, result);
    }

    @Test
    public void testGetDirection_whenSortIsIncorrect() {
        String sort = "gjgfaj";
        Sort.Direction result = PageableUtils.getDirection(sort);
        assertEquals(Sort.Direction.ASC, result);
    }

    @Test
    public void testGetDirection_whenSortIsNull() {
        String sort = null;
        Sort.Direction result = PageableUtils.getDirection(sort);
        assertEquals(Sort.Direction.ASC, result);
    }
}