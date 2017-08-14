package com.watson.mandlovutakeaways.services.pizzas.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizza;
import com.watson.mandlovutakeaways.factories.pizzas.MexicanPizzaFactory;
import com.watson.mandlovutakeaways.repository.pizzas.MexicanPizzaRepository;
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
public class MexicanPizzaServiceImplTest {
    @Autowired
    MexicanPizzaRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        MexicanPizza burgers = MexicanPizzaFactory.getMexicanPizza("Chicken Gatsby", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        MexicanPizza burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<MexicanPizza> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        MexicanPizza burgers = MexicanPizzaFactory.getMexicanPizza("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        MexicanPizza burgers = MexicanPizzaFactory.getMexicanPizza("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}