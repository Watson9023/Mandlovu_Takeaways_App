package com.watson.mandlovutakeaways.services.burgers.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.burgers.RibBurger;
import com.watson.mandlovutakeaways.factories.burgers.RibBurgerFactory;
import com.watson.mandlovutakeaways.repository.burgers.RibBurgerRepository;
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
public class RibBurgerServiceImplTest {
    @Autowired
    RibBurgerRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        RibBurger burgers = RibBurgerFactory.getRibBurger("Double Whopper", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        RibBurger burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<RibBurger> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        RibBurger burgers = RibBurgerFactory.getRibBurger("Double Whopper", "10.00");
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        RibBurger burgers = RibBurgerFactory.getRibBurger("Double Whopper", "10.00");
        repository.delete(burgers);
    }
}