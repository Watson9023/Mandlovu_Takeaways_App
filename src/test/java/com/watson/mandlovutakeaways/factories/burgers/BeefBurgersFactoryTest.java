package com.watson.mandlovutakeaways.factories.burgers;

import com.watson.mandlovutakeaways.domain.burgers.BeefBurgers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class BeefBurgersFactoryTest {
    @Test
    public void getBeefBurger() throws Exception {
        BeefBurgers burgers = BeefBurgersFactory.getBeefBurger("Beef Burgers","10");
        assertNotNull(burgers);
    }

}