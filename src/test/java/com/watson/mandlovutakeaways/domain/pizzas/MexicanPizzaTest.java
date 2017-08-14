package com.watson.mandlovutakeaways.domain.pizzas;

import com.watson.mandlovutakeaways.factories.pizzas.MexicanPizzaFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class MexicanPizzaTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza(name,price);
        assertNotNull(mexicanPizza.get_id());
    }

    @Test
    public void set_id() throws Exception {
        MexicanPizza mexicanPizza = new MexicanPizza();
        id++;
        mexicanPizza.set_id(id);
        assertEquals(mexicanPizza.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza("Mexican Pizza","10");
        assertNotNull(mexicanPizza.getName());
    }

    @Test
    public void setName() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza("Mexican Pizza","10");
        assertEquals(mexicanPizza.getName(),"Mexican Pizza");
    }

    @Test
    public void getPrice() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza("Mexican Pizza","10");
        assertNotNull(mexicanPizza.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        MexicanPizza mexicanPizza = MexicanPizzaFactory.getMexicanPizza("Mexican Pizza","10");
        assertEquals(mexicanPizza.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}