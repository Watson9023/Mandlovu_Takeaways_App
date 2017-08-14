package com.watson.mandlovutakeaways.domain.burgers;



import com.watson.mandlovutakeaways.factories.burgers.CheeseBurgerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class CheeseBurgerTest {

    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger(name, price);
        assertNotNull(cheeseBurger.get_id());
    }

    @Test
    public void set_id() throws Exception {
        CheeseBurger cheeseBurger = new CheeseBurger();
        id++;
        cheeseBurger.set_id(id);
        assertEquals(cheeseBurger.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger("Cheese Burger","10");
        assertNotNull(cheeseBurger.getName());
    }

    @Test
    public void setName() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger("Cheese Burger","10");
        assertEquals(cheeseBurger.getName(),"Cheese Burger");
    }

    @Test
    public void getPrice() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger("Cheese Burger","10");
        assertNotNull(cheeseBurger.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        CheeseBurger cheeseBurger = CheeseBurgerFactory.getCheeseBurger("Cheese Burger","10");
        assertEquals(cheeseBurger.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }

}