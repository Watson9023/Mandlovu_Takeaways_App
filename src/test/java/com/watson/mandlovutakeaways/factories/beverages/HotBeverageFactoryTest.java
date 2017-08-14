package com.watson.mandlovutakeaways.factories.beverages;

import com.watson.mandlovutakeaways.domain.beverages.HotBeverages;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class HotBeverageFactoryTest {
    @Test
    public void getHotBeverage() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage("Coffee","10");
        assertNotNull(hotBeverages);
    }

}