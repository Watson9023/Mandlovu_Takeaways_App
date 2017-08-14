package com.watson.mandlovutakeaways.domain.beverages;

import com.watson.mandlovutakeaways.factories.beverages.HotBeverageFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class HotBeveragesTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage(name, price);
        assertNotNull(hotBeverages.get_id());
    }

    @Test
    public void set_id() throws Exception {
        HotBeverages coldBeverages = new HotBeverages();
        id++;
        coldBeverages.set_id(id);
        assertEquals(coldBeverages.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage("Tea","5");
        assertNotNull(hotBeverages.getName());
    }

    @Test
    public void setName() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage("Coffee","5");
        assertEquals(hotBeverages.getName(),"Coffee");
    }

    @Test
    public void getPrice() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage("Coffee","5");
        assertNotNull(hotBeverages.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        HotBeverages hotBeverages = HotBeverageFactory.getHotBeverage("Tea","5");
        assertEquals(hotBeverages.getPrice(),"5");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}