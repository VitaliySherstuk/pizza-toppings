package com.vsharstuk.pizzatoppings.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

@UtilityClass
public final class PageableUtils {

    public static Pageable of(Integer pageNumber, Integer pageSize, String sort, String propertyName) {
        if (StringUtils.isNotEmpty(sort)) {
            return buildPageRequest(pageNumber, pageSize, JpaSort.by(getDirection(sort), propertyName));
        }
        return buildPageRequest(pageNumber, pageSize, JpaSort.by(Sort.Direction.ASC, propertyName));
    }

    public static Sort.Direction getDirection(String sort) {
        try {
            return Sort.Direction.fromString(sort);
        } catch (Exception e) {
            return Sort.Direction.ASC;
        }
    }

    public static PageRequest buildPageRequest(int page, int size, Sort sort) {
        return size == 0
                ? PageRequest.of(0, Integer.MAX_VALUE, sort)
                : PageRequest.of(page - 1 , size, sort);
    }
}
