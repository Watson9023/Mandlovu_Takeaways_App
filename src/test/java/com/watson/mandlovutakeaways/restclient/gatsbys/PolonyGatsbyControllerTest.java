package com.watson.mandlovutakeaways.restclient.gatsbys;

import com.watson.mandlovutakeaways.App;
import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import com.watson.mandlovutakeaways.factories.gatsbys.PolonyGatsbyFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Long on 8/14/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class PolonyGatsbyControllerTest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void createColdDrink() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        PolonyGatsby milkshakes = PolonyGatsbyFactory.getPolonyGatsby("Coke", "10");
        URI uri = restTemplate.postForLocation(BASE_URL +"/polonyGatsby/",milkshakes,PolonyGatsby.class);
    }

    @Test
    public void readColdDrinkByID() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        PolonyGatsby beverages = restTemplate.getForObject(BASE_URL + "/polonyGatsby/1",PolonyGatsby.class);
        System.out.println(beverages);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void findAllColdDrinks() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> coldBeverages = restTemplate.getForObject(BASE_URL + "/polonyGatsby/",List.class);
        System.out.println(coldBeverages);
    }

    @Test
    public void updateColdDrink() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        PolonyGatsby beverage = PolonyGatsbyFactory.getPolonyGatsby("Cokde","10");
        restTemplate.put(BASE_URL + "/polonyGatsby/1",beverage);
        System.out.println(beverage);
    }

    @Test
    public void deleteColdDrink() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL+"/polonyGatsby/1");
    }
}