package com.watson.mandlovutakeaways.services.burgers.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.burgers.ChickenBurgers;
import com.watson.mandlovutakeaways.factories.burgers.ChickenBurgerFactory;
import com.watson.mandlovutakeaways.repository.burgers.ChickenBurgerRepository;
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
public class ChickenBurgerServiceImplTest {
    @Autowired
    ChickenBurgerRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        ChickenBurgers burgers = ChickenBurgerFactory.getChickenburger("Double Whopper","10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        ChickenBurgers burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<ChickenBurgers> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        ChickenBurgers burgers = ChickenBurgerFactory.getChickenburger("Double Whopper","10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        ChickenBurgers burgers = ChickenBurgerFactory.getChickenburger("Double Whopper","10.00");
        repository.delete(burgers);
    }
}