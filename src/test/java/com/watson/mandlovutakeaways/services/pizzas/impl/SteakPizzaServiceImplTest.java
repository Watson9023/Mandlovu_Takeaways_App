package com.watson.mandlovutakeaways.services.pizzas.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;
import com.watson.mandlovutakeaways.factories.pizzas.SteakPizzaFactory;
import com.watson.mandlovutakeaways.repository.pizzas.SteakPizzaRepository;
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
public class SteakPizzaServiceImplTest {
    @Autowired
    SteakPizzaRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        SteakPizza burgers = SteakPizzaFactory.getSteakPizza("Chicken Gatsby", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        SteakPizza burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<SteakPizza> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        SteakPizza burgers = SteakPizzaFactory.getSteakPizza("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        SteakPizza burgers = SteakPizzaFactory.getSteakPizza("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}