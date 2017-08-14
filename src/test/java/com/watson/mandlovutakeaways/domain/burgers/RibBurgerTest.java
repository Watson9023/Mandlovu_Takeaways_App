package com.watson.mandlovutakeaways.domain.burgers;

import com.watson.mandlovutakeaways.factories.burgers.RibBurgerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class RibBurgerTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger(name, price);
        assertNotNull(ribBurger.get_id());
    }

    @Test
    public void set_id() throws Exception {
        RibBurger ribBurger = new RibBurger();
        id++;
        ribBurger.set_id(id);
        assertEquals(ribBurger.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger("Rib Burger","10");
        assertNotNull(ribBurger.getName());
    }

    @Test
    public void setName() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger("Rib Burger","10");
        assertEquals(ribBurger.getName(),"Rib Burger");
    }

    @Test
    public void getPrice() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger("Rib Burger","10");
        assertNotNull(ribBurger.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        RibBurger ribBurger = RibBurgerFactory.getRibBurger("Rib Burger","10");
        assertEquals(ribBurger.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}