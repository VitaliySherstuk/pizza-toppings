package com.vsharstuk.pizzatoppings.repository;

import com.vsharstuk.pizzatoppings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
