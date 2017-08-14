package com.watson.mandlovutakeaways.factories.gatsbys;

import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsby;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenGatsbyFactoryTest {
    @Test
    public void getChickenGatsby() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby("Chicken Gatsby","10");
        assertNotNull(chickenGatsby);
    }

}