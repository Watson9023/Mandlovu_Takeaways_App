package com.watson.mandlovutakeaways.services.gatsbys.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsby;
import com.watson.mandlovutakeaways.factories.gatsbys.SteakGatsbyFactory;
import com.watson.mandlovutakeaways.repository.gatsbys.SteakGatsbyRepository;
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
public class SteakGatsbyServiceImplTest {
    @Autowired
    SteakGatsbyRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        SteakGatsby burgers = SteakGatsbyFactory.getSteakGatsby("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        SteakGatsby burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<SteakGatsby> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        SteakGatsby burgers = SteakGatsbyFactory.getSteakGatsby("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        SteakGatsby burgers = SteakGatsbyFactory.getSteakGatsby("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}