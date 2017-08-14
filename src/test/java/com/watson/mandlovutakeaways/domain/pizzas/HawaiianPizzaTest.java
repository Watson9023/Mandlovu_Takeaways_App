package com.watson.mandlovutakeaways.domain.pizzas;

import com.watson.mandlovutakeaways.factories.pizzas.HawaiianPizzaFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class HawaiianPizzaTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza(name,price);
        assertNotNull(hawaiianPizza.get_id());
    }

    @Test
    public void set_id() throws Exception {
        HawaiianPizza hawaiianPizza = new HawaiianPizza();
        id++;
        hawaiianPizza.set_id(id);
        assertEquals(hawaiianPizza.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza("Hawaiian Pizza","10");
        assertNotNull(hawaiianPizza.getName());
    }

    @Test
    public void setName() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza("Hawaiian Pizza","10");
        assertEquals(hawaiianPizza.getName(),"Hawaiian Pizza");
    }

    @Test
    public void getPrice() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza("Hawaiian Pizza","10");
        assertNotNull(hawaiianPizza.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        HawaiianPizza hawaiianPizza = HawaiianPizzaFactory.getHawaiianPizza("Hawaiian Pizza","10");
        assertEquals(hawaiianPizza.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}