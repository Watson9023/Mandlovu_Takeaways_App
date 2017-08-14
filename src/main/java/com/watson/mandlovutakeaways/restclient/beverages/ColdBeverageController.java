package com.watson.mandlovutakeaways.restclient.beverages;


import com.watson.mandlovutakeaways.domain.beverages.ColdBeverages;
import com.watson.mandlovutakeaways.services.beverages.ColdBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class ColdBeverageController {
    @Autowired
    private ColdBeverageService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/coldDrink/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<ColdBeverages> createColdDrink(@RequestBody ColdBeverages coldBeverages) {
        service.create(coldBeverages);
        return new ResponseEntity<ColdBeverages>(coldBeverages, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/coldDrink/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ColdBeverages> readColdDrinkByID(@PathVariable("id") long id) {
        ColdBeverages drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<ColdBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ColdBeverages>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/coldDrinks/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ColdBeverages>> findAllColdDrinks() {
        Iterable<ColdBeverages> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<ColdBeverages>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<ColdBeverages>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/coldDrink/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<ColdBeverages> updateColdDrink(@PathVariable("id") long id, @RequestBody ColdBeverages coldBeverages)
    {
        ColdBeverages currentDrink = service.readById(id);
        if(currentDrink == null)
        {
            return new ResponseEntity<ColdBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ColdBeverages update = new ColdBeverages.Builder()
                .copy(currentDrink)
                .name(coldBeverages.getName())
                .price(coldBeverages.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<ColdBeverages>(update,HttpStatus.OK);
    }

    /*
        DELETE ColdDrink
    * */
    @RequestMapping(value = "/coldDrink/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ColdBeverages> deleteColdDrink(@PathVariable("id") long id)
    {
        ColdBeverages beverage = service.readById(id);
        if(beverage == null)
        {
            return new ResponseEntity<ColdBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(beverage);
        return new ResponseEntity<ColdBeverages>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/test")
    public String testDeployment()
    {
        return "Hello Boxfuse";
    }

    @RequestMapping(value ="/")
    public String defaultMapping()
    {
        return  "Deployed and developed By: Watson Matunhire;" + "\n" +
                "Group Part Time;" + "\n"+
                "Student Number: 213215004;" + "\n" +
                "Description: Backend for a takeaway mobile app";
    }
}

