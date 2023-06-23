package com.vsharstuk.pizzatoppings.repository;

import com.vsharstuk.pizzatoppings.dto.ToppingReportDto;
import com.vsharstuk.pizzatoppings.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT new com.vsharstuk.pizzatoppings.dto.ToppingReportDto(tp.name, COUNT(u.id)) " +
            "FROM User u LEFT JOIN u.toppings tp GROUP BY tp.name ORDER BY COUNT(u.id) ASC")
    Page<ToppingReportDto> countUsersPerTopping(Pageable pageable);
}
