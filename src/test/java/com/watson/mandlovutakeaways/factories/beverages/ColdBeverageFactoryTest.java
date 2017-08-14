package com.watson.mandlovutakeaways.factories.beverages;

import com.watson.mandlovutakeaways.domain.beverages.ColdBeverages;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ColdBeverageFactoryTest {
    @Test
    public void getColdBeverage() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage("Coke","10");
        assertNotNull(coldBeverages);
    }

}