package com.watson.mandlovutakeaways.factories.burgers;

import com.watson.mandlovutakeaways.domain.burgers.ChickenBurgers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenBurgerFactoryTest {
    @Test
    public void getChickenburger() throws Exception {
        ChickenBurgers burgers = ChickenBurgerFactory.getChickenburger("Chicken Burger", "10");
        assertNotNull(burgers);
    }

}