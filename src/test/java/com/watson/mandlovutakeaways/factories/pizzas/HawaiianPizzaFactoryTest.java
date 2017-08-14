package com.watson.mandlovutakeaways.factories.pizzas;

import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizza;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *Created by Long on 8/14/2017.
 */
public class HawaiianPizzaFactoryTest {
    @Test
    public void getHawaiianPizza() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza("Hawaiian Pizza","10");
        assertNotNull(hawaiianPizza);
    }

}