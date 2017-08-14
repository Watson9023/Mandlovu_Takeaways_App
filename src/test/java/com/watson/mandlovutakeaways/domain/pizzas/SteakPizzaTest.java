package com.watson.mandlovutakeaways.domain.pizzas;

import com.watson.mandlovutakeaways.factories.pizzas.SteakPizzaFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakPizzaTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza(name,price);
        assertNotNull(steakPizza.get_id());
    }

    @Test
    public void set_id() throws Exception {
        SteakPizza steakPizza = new SteakPizza();
        id++;
        steakPizza.set_id(id);
        assertEquals(steakPizza.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza("Steak Pizza","10");
        assertNotNull(steakPizza.getName());
    }

    @Test
    public void setName() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza("Steak Pizza","10");
        assertEquals(steakPizza.getName(),"Steak Pizza");
    }

    @Test
    public void getPrice() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza("Steak Pizza","10");
        assertNotNull(steakPizza.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        SteakPizza steakPizza = SteakPizzaFactory.getSteakPizza("Steak Pizza","10");
        assertEquals(steakPizza.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}