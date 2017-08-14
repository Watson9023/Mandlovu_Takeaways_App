package com.watson.mandlovutakeaways.factories.pizzas;

import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizza;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class MexicanPizzaFactoryTest {
    @Test
    public void getMexicanPizza() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza("Mexican Pizza","10");
        assertNotNull(mexicanPizza);
    }

}