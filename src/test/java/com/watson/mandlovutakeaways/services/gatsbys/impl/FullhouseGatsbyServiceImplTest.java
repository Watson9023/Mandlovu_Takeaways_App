package com.watson.mandlovutakeaways.services.gatsbys.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsby;
import com.watson.mandlovutakeaways.factories.gatsbys.FullhouseGatsbyFactory;
import com.watson.mandlovutakeaways.repository.gatsbys.FullhouseGatsbysRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class FullhouseGatsbyServiceImplTest {
    @Autowired
    FullhouseGatsbysRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        FullhouseGatsby burgers = FullhouseGatsbyFactory.getFullhouseGatsby("Chicken Gatsby", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        FullhouseGatsby burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<FullhouseGatsby> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        FullhouseGatsby burgers = FullhouseGatsbyFactory.getFullhouseGatsby("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        FullhouseGatsby burgers = FullhouseGatsbyFactory.getFullhouseGatsby("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}