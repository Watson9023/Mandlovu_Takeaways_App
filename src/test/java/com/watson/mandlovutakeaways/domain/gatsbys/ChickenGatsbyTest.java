package com.watson.mandlovutakeaways.domain.gatsbys;

import com.watson.mandlovutakeaways.factories.gatsbys.ChickenGatsbyFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenGatsbyTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby(name, price);
        assertNotNull(chickenGatsby.get_id());
    }

    @Test
    public void set_id() throws Exception {
        ChickenGatsby chickenGatsby = new ChickenGatsby();
        id++;
        chickenGatsby.set_id(id);
        assertEquals(chickenGatsby.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby("Chicken Gatsby","10");
        assertNotNull(chickenGatsby.getName());
    }

    @Test
    public void setName() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby("Chicken Gatsby","10");
        assertEquals(chickenGatsby.getName(),"Chicken Gatsby");
    }

    @Test
    public void getPrice() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby("Chicken Gatsby","10");
        assertNotNull(chickenGatsby.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        ChickenGatsby chickenGatsby = ChickenGatsbyFactory.getChickenGatsby("Chicken Gatsby","10");
        assertEquals(chickenGatsby.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }

}