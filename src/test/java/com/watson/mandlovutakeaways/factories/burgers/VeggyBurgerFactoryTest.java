package com.watson.mandlovutakeaways.factories.burgers;

import com.watson.mandlovutakeaways.domain.burgers.VeggyBurger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class VeggyBurgerFactoryTest {
    @Test
    public void getVeggyBurger() throws Exception {
        VeggyBurger burger = VeggyBurgerFactory.getVeggyBurger("Veggy Burger","10");
        assertNotNull(burger);
    }

}