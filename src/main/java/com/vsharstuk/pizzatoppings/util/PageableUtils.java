package com.vsharstuk.pizzatoppings.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UtilityClass
public final class PageableUtils {

    public static Pageable of(Integer pageNumber, Integer pageSize, String sort) {
        if (StringUtils.isNotEmpty(sort)) {
            return of(pageNumber, pageSize, Sort.by(getDirection(sort)));
        }
        return of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC));
    }

    public static Sort.Direction getDirection(String sort) {
        try {
            return Sort.Direction.fromString(sort);
        } catch (Exception e) {
            return Sort.Direction.ASC;
        }
    }

    public static PageRequest of(int page, int size, Sort sort) {
        return size == 0
                ? PageRequest.of(0, Integer.MAX_VALUE, sort)
                : PageRequest.of(page - 1, size, sort);
    }
}
