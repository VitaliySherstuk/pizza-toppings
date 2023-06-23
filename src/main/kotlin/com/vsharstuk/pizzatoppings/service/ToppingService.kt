package com.vsharstuk.pizzatoppings.service;

import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.dto.ToppingReportDto;
import com.vsharstuk.pizzatoppings.repository.ToppingRepository;
import com.vsharstuk.pizzatoppings.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToppingService {

    private final ToppingRepository toppingRepository;
    private final UserRepository userRepository;

    @Transactional
    public void create(List<Topping> toppings) {
        toppings.stream()
                .map(Topping::getName)
                .forEach(toppingRepository::saveOrUpdate);
    }

    public List<Topping> findAllToppingByName(List<String> names) {
        return toppingRepository.findAllByNameIn(names);
    }

    public Page<ToppingReportDto> countUsersPerToppings(Pageable pageable) {
        return userRepository.countUsersPerTopping(pageable);
    }
}
