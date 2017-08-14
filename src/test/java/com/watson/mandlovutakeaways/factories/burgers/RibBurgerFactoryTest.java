package com.watson.mandlovutakeaways.factories.burgers;

import com.watson.mandlovutakeaways.domain.burgers.RibBurger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class RibBurgerFactoryTest {
    @Test
    public void getRibBurger() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger("Rib Burger","10");
        assertNotNull(ribBurger);
    }

}