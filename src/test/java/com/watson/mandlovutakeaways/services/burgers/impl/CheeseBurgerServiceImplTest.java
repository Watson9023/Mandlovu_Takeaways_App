package com.watson.mandlovutakeaways.services.burgers.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.burgers.CheeseBurger;
import com.watson.mandlovutakeaways.factories.burgers.CheeseBurgerFactory;
import com.watson.mandlovutakeaways.repository.burgers.CheeseBurgerRepository;
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
public class CheeseBurgerServiceImplTest {
    @Autowired
    CheeseBurgerRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        CheeseBurger burgers = CheeseBurgerFactory.getCheeseBurger("Double Whopper", "10.00");
        repository.save(burgers);
        id = burgers.get_id();
        assertNotNull(burgers.get_id());
    }

    @Test
    public void readById() throws Exception {
        CheeseBurger burgers = repository.findOne(id);
        assertNotNull(burgers);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<CheeseBurger> burgerses = repository.findAll();
        Assert.assertNotNull(burgerses);
    }

    @Test
    public void update() throws Exception {
        CheeseBurger burgers = CheeseBurgerFactory.getCheeseBurger("Double Whopper","10.00");
        repository.save(burgers);
        id = burgers.get_id();
        repository.save(burgers);
        assertNotNull(burgers);
    }

    @Test
    public void delete() throws Exception {
        CheeseBurger burgers = CheeseBurgerFactory.getCheeseBurger("Double Whopper","10.00");
        repository.delete(burgers);
    }
}