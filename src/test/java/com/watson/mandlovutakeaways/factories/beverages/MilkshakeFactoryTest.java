package com.watson.mandlovutakeaways.factories.beverages;

import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class MilkshakeFactoryTest {
    @Test
    public void getMilkshake() throws Exception {
        Milkshakes milkshakes = MilkshakeFactory.getMilkshake("Strawberry Milkshake","20");
        assertNotNull(milkshakes);
    }

}