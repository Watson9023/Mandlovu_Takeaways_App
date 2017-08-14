package com.watson.mandlovutakeaways.factories.gatsbys;

import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class PolonyGatsbyFactoryTest {
    @Test
    public void getPolonyGatsby() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby("Polony Gatsby","100");
        assertNotNull(polonyGatsby);
    }

}