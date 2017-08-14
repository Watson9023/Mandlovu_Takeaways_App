package com.watson.mandlovutakeaways.services.beverages.impl;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.beverages.ColdBeverages;
import com.watson.mandlovutakeaways.factories.beverages.ColdBeverageFactory;
import com.watson.mandlovutakeaways.repository.beverages.ColdBeveragesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Long on 8/14/2017.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ColdBeverageServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ColdBeveragesRepository repository;
    long id;

    @Test
    public void create() throws Exception {
        repository.deleteAll();

        ColdBeverages beverages = ColdBeverageFactory.getColdBeverage("Coke", "10.00");
        repository.save(beverages);
        id = beverages.get_id();
        assertNotNull(beverages.get_id());
    }

    @Test
    public void readById() throws Exception {
        ColdBeverages beverages = repository.findOne(id);
        assertNotNull(beverages);
    }

    @Test
    public void readAll() throws Exception {
        Iterable<ColdBeverages> coldBeveragesList = repository.findAll();
        Assert.assertNotNull(coldBeveragesList);
    }

    @Test
    public void update() throws Exception {
        ColdBeverages beverages =ColdBeverageFactory.getColdBeverage("Coke","10.00");
        repository.save(beverages);
        id = beverages.get_id();
        repository.save(beverages);
        assertNotNull(beverages);
    }

    @Test
    public void delete() throws Exception {
        ColdBeverages beverages =ColdBeverageFactory.getColdBeverage("Coke","10.00");
        repository.delete(beverages);
    }
}