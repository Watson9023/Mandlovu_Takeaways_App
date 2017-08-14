package com.watson.mandlovutakeaways.domain.gatsbys;

import com.watson.mandlovutakeaways.factories.gatsbys.PolonyGatsbyFactory;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Long on 8/14/2017.
 */
public class PolonyGatsbyTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby(name, price);
        assertNotNull(polonyGatsby.get_id());
    }

    @Test
    public void set_id() throws Exception {
        PolonyGatsby polonyGatsby = new PolonyGatsby();
        id++;
        polonyGatsby.set_id(id);
        assertEquals(polonyGatsby.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby("Polony Gatsby","10");
        assertNotNull(polonyGatsby.getName());
    }

    @Test
    public void setName() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby("Polony Gatsby","10");
        assertEquals(polonyGatsby.getName(),"Polony Gatsby");
    }

    @Test
    public void getPrice() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby("Polony Gatsby","10");
        assertNotNull(polonyGatsby.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        PolonyGatsby polonyGatsby = PolonyGatsbyFactory.getPolonyGatsby("Polony Gatsby","10");
        assertEquals(polonyGatsby.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}