package com.vsharstuk.pizzatoppings.service;

import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.repository.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToppingService {

    private final ToppingRepository toppingRepository;

    @Transactional
    public void create(List<Topping> toppings) {
        toppings.stream()
                .map(Topping::getName)
                .forEach(toppingRepository::saveOrUpdate);
    }

    public List<Topping> findAllToppingByName(List<String> names) {
        return toppingRepository.findAllByNameIn(names);
    }
}
