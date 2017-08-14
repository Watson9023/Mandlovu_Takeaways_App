package com.watson.mandlovutakeaways.domain.pizzas;

import com.watson.mandlovutakeaways.factories.pizzas.ChickenPizzaFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenPizzaTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza(name,price);
        assertNotNull(chickenPizza.get_id());
    }

    @Test
    public void set_id() throws Exception {
        ChickenPizza chickenPizza = new ChickenPizza();
        id++;
        chickenPizza.set_id(id);
        assertEquals(chickenPizza.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza("Chicken Pizza","10");
        assertNotNull(chickenPizza.getName());
    }

    @Test
    public void setName() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza("Chicken Pizza","10");
        assertEquals(chickenPizza.getName(),"Chicken Pizza");
    }

    @Test
    public void getPrice() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza("Chicken Pizza","10");
        assertNotNull(chickenPizza.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        ChickenPizza chickenPizza = ChickenPizzaFactory.getChickenPizza("Chicken Pizza","10");
        assertEquals(chickenPizza.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}