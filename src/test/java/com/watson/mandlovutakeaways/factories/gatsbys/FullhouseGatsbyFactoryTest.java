package com.watson.mandlovutakeaways.factories.gatsbys;

import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsby;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class FullhouseGatsbyFactoryTest {
    @Test
    public void getFullhouseGatsby() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby("Fullhouse Gatsby", "10");
        assertNotNull(fullhouseGatsby);
    }

}