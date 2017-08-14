package com.watson.mandlovutakeaways.domain.burgers;

import com.watson.mandlovutakeaways.factories.burgers.ChickenBurgerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenBurgersTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        ChickenBurgers chickenburger = ChickenBurgerFactory.getChickenburger(name,price);
        assertNotNull(chickenburger.get_id());
    }

    @Test
    public void set_id() throws Exception {
        ChickenBurgers chickenBurgers = new ChickenBurgers();
        id++;
        chickenBurgers.set_id(id);
        assertEquals(chickenBurgers.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        ChickenBurgers chickenBurgers = ChickenBurgerFactory.getChickenburger("Chicken Burger","10");
        assertNotNull(chickenBurgers.getName());
    }

    @Test
    public void setName() throws Exception {
        ChickenBurgers chickenBurgers = ChickenBurgerFactory.getChickenburger("Chicken Burger","10");
        assertEquals(chickenBurgers.getName(),"Chicken Burger");
    }

    @Test
    public void getPrice() throws Exception {
        ChickenBurgers chickenBurgers = ChickenBurgerFactory.getChickenburger("Chicken Burger","10");
        assertNotNull(chickenBurgers.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        ChickenBurgers chickenBurgers = ChickenBurgerFactory.getChickenburger("Chicken Burger","10");
        assertEquals(chickenBurgers.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }

}