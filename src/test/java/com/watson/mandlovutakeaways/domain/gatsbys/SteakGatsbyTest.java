package com.watson.mandlovutakeaways.domain.gatsbys;

import com.watson.mandlovutakeaways.factories.gatsbys.SteakGatsbyFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakGatsbyTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby(name,price);
        assertNotNull(steakGatsby.get_id());
    }

    @Test
    public void set_id() throws Exception {
        SteakGatsby steakGatsby = new SteakGatsby();
        id++;
        steakGatsby.set_id(id);
        assertEquals(steakGatsby.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby("Steak Gatsby","10");
        assertNotNull(steakGatsby.getName());
    }

    @Test
    public void setName() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby("Steak Gatsby","10");
        assertEquals(steakGatsby.getName(),"Steak Gatsby");
    }

    @Test
    public void getPrice() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby("Steak Gatsby","10");
        assertNotNull(steakGatsby.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        SteakGatsby steakGatsby = SteakGatsbyFactory.getSteakGatsby("Steak Gatsby","10");
        assertEquals(steakGatsby.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}