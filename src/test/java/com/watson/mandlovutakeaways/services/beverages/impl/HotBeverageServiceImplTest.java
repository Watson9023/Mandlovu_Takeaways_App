package com.watson.mandlovutakeaways.services.beverages.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.beverages.HotBeverages;
import com.watson.mandlovutakeaways.factories.beverages.HotBeverageFactory;
import com.watson.mandlovutakeaways.repository.beverages.HotBeverageRepository;
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
public class HotBeverageServiceImplTest {
    @Autowired
    HotBeverageRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        HotBeverages beverages = HotBeverageFactory.getHotBeverage("Coffee","10.00");
        repository.save(beverages);
        id = beverages.get_id();
        assertNotNull(beverages.get_id());
    }

    @Test
    public void readById() throws Exception {
        HotBeverages beverages = repository.findOne(id);
        assertNotNull(beverages);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<HotBeverages> hotBeverages = repository.findAll();
        Assert.assertNotNull(hotBeverages);
    }

    @Test
    public void update() throws Exception {
        HotBeverages beverages =HotBeverageFactory.getHotBeverage("Tea","10.00");
        repository.save(beverages);
        id = beverages.get_id();
        repository.save(beverages);
        assertNotNull(beverages);
    }

    @Test
    public void delete() throws Exception {
        HotBeverages beverages =HotBeverageFactory.getHotBeverage("Tea","10.00");
        repository.delete(beverages);
    }
}