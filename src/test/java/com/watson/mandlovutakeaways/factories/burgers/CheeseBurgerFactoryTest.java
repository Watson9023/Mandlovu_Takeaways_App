package com.watson.mandlovutakeaways.factories.burgers;

import com.watson.mandlovutakeaways.domain.burgers.CheeseBurger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class CheeseBurgerFactoryTest {
    @Test
    public void getCheeseBurger() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger("Cheese Burger","10");
        assertNotNull(cheeseBurger);
    }

}