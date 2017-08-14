package com.watson.mandlovutakeaways.domain.beverages;

import com.watson.mandlovutakeaways.factories.beverages.ColdBeverageFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ColdBeveragesTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage(name,price);
        assertNotNull(coldBeverages.get_id());
    }

    @Test
    public void set_id() throws Exception {
        ColdBeverages coldBeverages = new ColdBeverages();
        id++;
        coldBeverages.set_id(id);
        assertEquals(coldBeverages.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage("Coke","10");
        assertNotNull(coldBeverages.getName());
    }

    @Test
    public void setName() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage("Coke","10");
        assertEquals(coldBeverages.getName(),"Coke");
    }

    @Test
    public void getPrice() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage("coke","10");
        assertNotNull(coldBeverages.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        ColdBeverages coldBeverages = ColdBeverageFactory.getColdBeverage("Fanta","10");
        assertEquals(coldBeverages.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}