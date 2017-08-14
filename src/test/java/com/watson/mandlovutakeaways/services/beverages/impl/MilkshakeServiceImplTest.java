package com.watson.mandlovutakeaways.services.beverages.impl;
import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;
import com.watson.mandlovutakeaways.factories.beverages.MilkshakeFactory;
import com.watson.mandlovutakeaways.repository.beverages.MilkshakeRepository;
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
public class MilkshakeServiceImplTest {
    @Autowired
    MilkshakeRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        Milkshakes beverages = MilkshakeFactory.getMilkshake("Coke Float","10.00");
        repository.save(beverages);
        id = beverages.get_id();
        assertNotNull(beverages.get_id());
    }

    @Test
    public void readById() throws Exception {
        Milkshakes beverages = repository.findOne(id);
        assertNotNull(beverages);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<Milkshakes> coldBeveragesList = repository.findAll();
        Assert.assertNotNull(coldBeveragesList);
    }

    @Test
    public void update() throws Exception {
        Milkshakes beverages =MilkshakeFactory.getMilkshake("Coke Float","10.00");
        repository.save(beverages);
        id = beverages.get_id();
        repository.save(beverages);
        assertNotNull(beverages);
    }

    @Test
    public void delete() throws Exception {
        Milkshakes beverages =MilkshakeFactory.getMilkshake("Strawberry","10.00");
        repository.delete(beverages);
    }
}