package com.vsharstuk.pizzatoppings.repository;

import com.vsharstuk.pizzatoppings.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {

    @Modifying
    @Query(value = "insert into toppings(name) values(:name) on conflict do nothing", nativeQuery = true)
    void saveOrUpdate(@Param("name") String toppingName);

    List<Topping> findAllByNameIn(List<String> names);
}
