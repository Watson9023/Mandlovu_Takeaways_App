package com.watson.mandlovutakeaways.services.pizzas.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizza;
import com.watson.mandlovutakeaways.factories.pizzas.HawaiianPizzaFactory;
import com.watson.mandlovutakeaways.repository.pizzas.HawaiianPizzaRepository;
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
public class HawaiianPizzaServiceImplTest {
    @Autowired
    HawaiianPizzaRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        HawaiianPizza burgers = HawaiianPizzaFactory.getHawaiianPizza("Chicken Gatsby", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        HawaiianPizza burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<HawaiianPizza> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        HawaiianPizza burgers = HawaiianPizzaFactory.getHawaiianPizza("Chicken Gatsby", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        HawaiianPizza burgers = HawaiianPizzaFactory.getHawaiianPizza("Chicken Gatsby", "10.00");
        repository.delete(burgers);
    }
}