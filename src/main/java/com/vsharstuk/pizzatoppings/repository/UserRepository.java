package com.vsharstuk.pizzatoppings.repository;

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto;
import com.vsharstuk.pizzatoppings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT new com.vsharstuk.pizzatoppings.dto.ToppingReportDto(tp.name, COUNT(u.id)) FROM User u LEFT JOIN u.toppings tp GROUP BY tp.name")
    List<ToppingReportDto> countUsersPerTopping();
}
