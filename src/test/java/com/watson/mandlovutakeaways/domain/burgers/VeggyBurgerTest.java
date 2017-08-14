package com.watson.mandlovutakeaways.domain.burgers;

import com.watson.mandlovutakeaways.factories.burgers.VeggyBurgerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class VeggyBurgerTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        VeggyBurger veggyBurger = VeggyBurgerFactory.getVeggyBurger(name,price);
        assertNotNull(veggyBurger.get_id());
    }

    @Test
    public void set_id() throws Exception {
        VeggyBurger veggyBurger = new VeggyBurger();
        id++;
        veggyBurger.set_id(id);
        assertEquals(veggyBurger.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        VeggyBurger veggyBurger = VeggyBurgerFactory.getVeggyBurger("Veggy Burger","10");
        assertNotNull(veggyBurger.getName());
    }

    @Test
    public void setName() throws Exception {
        VeggyBurger veggyBurger = VeggyBurgerFactory.getVeggyBurger("Veggy Burger","10");
        assertEquals(veggyBurger.getName(),"Veggy Burger");
    }

    @Test
    public void getPrice() throws Exception {
        VeggyBurger veggyBurger = VeggyBurgerFactory.getVeggyBurger("Veggy Burger","10");
        assertNotNull(veggyBurger.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        VeggyBurger veggyBurger = VeggyBurgerFactory.getVeggyBurger("Veggy Burger","10");
        assertEquals(veggyBurger.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}