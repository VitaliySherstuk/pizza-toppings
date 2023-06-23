package com.vsharstuk.pizzatoppings.service;

import com.vsharstuk.pizzatoppings.entity.Topping;
import com.vsharstuk.pizzatoppings.entity.User;
import com.vsharstuk.pizzatoppings.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ToppingService toppingService;
    @InjectMocks
    private UserService userService;

    private static final String FIRST_TOPPING_NAME = "first_topping";
    private static final String SECOND_TOPPING_NAME = "second_topping";
    private static final Long FIRST_TOPPING_ID = 1L;
    private static final Long SECOND_TOPPING_ID = 2L;
    private static final Long USER_ID = 123L;
    private static final String USER_EMAIL = "test@example.com";

    @Test
    public void testSubmitToppings_ToppingsWereSubmitted() {
        //given
        User user = createUser();
        List<Topping> toppings = createToppings();

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        //when
        when(userRepository.getById(USER_ID)).thenReturn(user);
        doNothing().when(toppingService).create(toppings);
        when(toppingService.findAllToppingByName(Arrays.asList(FIRST_TOPPING_NAME, SECOND_TOPPING_NAME))).thenReturn(toppings);
        userService.submit(USER_ID, toppings);

        //then
        verify(userRepository, times(1)).getById(USER_ID);
        verify(toppingService, times(1)).create(toppings);
        verify(toppingService, times(1)).findAllToppingByName(Arrays.asList(FIRST_TOPPING_NAME, SECOND_TOPPING_NAME));
        verify(userRepository, times(1)).save(captor.capture());
        User result = captor.getValue();
        assertEquals(USER_EMAIL, result.getEmail());
        assertEquals(USER_ID, result.getId());
        assertEquals(toppings, result.getToppings());
    }

    @Test
    public void testGetUserById() {
        //given
        User user = createUser();

        //when
        when(userRepository.getById(USER_ID)).thenReturn(user);
        User result = userService.getUser(USER_ID);

        //then
        assertEquals(user, result);
        verify(userRepository, times(1)).getById(USER_ID);
    }

    private User createUser() {
        User user = new User();
        user.setId(USER_ID);
        user.setEmail(USER_EMAIL);
        return user;
    }

    private List<Topping> createToppings() {
        Topping firstTopping = new Topping();
        firstTopping.setId(FIRST_TOPPING_ID);
        firstTopping.setName(FIRST_TOPPING_NAME);

        Topping secondTopping = new Topping();
        secondTopping.setId(SECOND_TOPPING_ID);
        secondTopping.setName(SECOND_TOPPING_NAME);
        return Arrays.asList(firstTopping, secondTopping);
    }
}