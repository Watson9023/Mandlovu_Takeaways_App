package com.watson.mandlovutakeaways.factories.pizzas;

import com.watson.mandlovutakeaways.domain.pizzas.ChickenPizza;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenPizzaFactoryTest {
    @Test
    public void getChickenPizza() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza("Chicken Pizza","10");
        assertNotNull(chickenPizza);
    }

}