package com.watson.mandlovutakeaways.factories.pizzas;

import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakPizzaFactoryTest {
    @Test
    public void getSteakPizza() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza("Steak Pizza","10");
        assertNotNull(steakPizza);
    }

}