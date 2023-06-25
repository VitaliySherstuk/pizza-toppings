package com.vsharstuk.pizzatoppings.util

import org.apache.commons.lang3.StringUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.JpaSort


object PageableUtils {
    @JvmStatic
    fun of(pageNumber: Int, pageSize: Int, sort: String, propertyName: String?): Pageable {
        return if (StringUtils.isNotEmpty(sort)) {
            buildPageRequest(pageNumber, pageSize, JpaSort.by(getDirection(sort), propertyName))
        } else buildPageRequest(pageNumber, pageSize, JpaSort.by(Sort.Direction.ASC, propertyName))
    }

    @JvmStatic
    fun getDirection(sort: String): Sort.Direction {
        return try {
            Sort.Direction.fromString(sort)
        } catch (e: Exception) {
            Sort.Direction.ASC
        }
    }

    fun buildPageRequest(page: Int, size: Int, sort: Sort): PageRequest {
        return if (size == 0) PageRequest.of(0, Int.MAX_VALUE, sort) else PageRequest.of(page - 1, size, sort)
    }
}
