package com.watson.mandlovutakeaways.services.gatsbys.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import com.watson.mandlovutakeaways.factories.gatsbys.PolonyGatsbyFactory;
import com.watson.mandlovutakeaways.repository.gatsbys.PolonyGatsbyRepository;
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
public class PolonyGatsbyServiceImplTest {
    @Autowired
    PolonyGatsbyRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        PolonyGatsby burgers = PolonyGatsbyFactory.getPolonyGatsby("Chicken Gatsby", "10.00");        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        PolonyGatsby burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<PolonyGatsby> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        PolonyGatsby burgers = PolonyGatsbyFactory.getPolonyGatsby("Chicken Gatsby", "10.00");        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        PolonyGatsby burgers = PolonyGatsbyFactory.getPolonyGatsby("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}