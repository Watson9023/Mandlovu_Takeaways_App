package com.watson.mandlovutakeaways.domain.gatsbys;

import com.watson.mandlovutakeaways.factories.gatsbys.FullhouseGatsbyFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
public class FullhouseGatsbyTest {
    int id = 0;
    String name;
    String price;
    @Test
    public void get_id() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby(name,price);
        assertNotNull(fullhouseGatsby.get_id());
    }

    @Test
    public void set_id() throws Exception {
        FullhouseGatsby fullhouseGatsby = new FullhouseGatsby();
        id++;
        fullhouseGatsby.set_id(id);
        assertEquals(fullhouseGatsby.get_id(),id);
    }

    @Test
    public void getName() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby("Fullhouse Gatsby","10");
        assertNotNull(fullhouseGatsby.getName());
    }

    @Test
    public void setName() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby("Fullhouse Gatsby","10");
        assertEquals(fullhouseGatsby.getName(),"Fullhouse Gatsby");
    }

    @Test
    public void getPrice() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby("Fullhouse Gatsby","10");
        assertNotNull(fullhouseGatsby.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        FullhouseGatsby fullhouseGatsby = FullhouseGatsbyFactory.getFullhouseGatsby("Fullhouse Gatsby","10");
        assertEquals(fullhouseGatsby.getPrice(),"10");
    }

    @Test
    public void testHashCode() throws Exception {
        assertNotNull(id ^(id >>> 32));
    }
}