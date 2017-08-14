package com.watson.mandlovutakeaways.factories.gatsbys;

import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsby;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakGatsbyFactoryTest {
    @Test
    public void getSteakGatsby() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby("Steak Gatsby","10");
        assertNotNull(steakGatsby);
    }

}