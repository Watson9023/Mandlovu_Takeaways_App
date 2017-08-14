package com.watson.mandlovutakeaways.restclient.beverages;


import com.watson.mandlovutakeaways.domain.beverages.HotBeverages;
import com.watson.mandlovutakeaways.services.beverages.HotBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class HotBeverageController
{
    @Autowired
    private HotBeverageService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/hotDrink/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<HotBeverages> createColdDrink(@RequestBody HotBeverages hotBeverages) {
        service.create(hotBeverages);
        return new ResponseEntity<HotBeverages>(hotBeverages, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/hotDrink/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HotBeverages> readColdDrinkByID(@PathVariable("id") long id) {
        HotBeverages drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<HotBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HotBeverages>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/hotDrinks/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<HotBeverages>> findAllColdDrinks() {
        Iterable<HotBeverages> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<HotBeverages>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<HotBeverages>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/hotDrink/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<HotBeverages> updateColdDrink(@PathVariable("id") long id, @RequestBody HotBeverages coldBeverages)
    {
        HotBeverages currentDrink = service.readById(id);
        if(currentDrink == null)
        {
            return new ResponseEntity<HotBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        HotBeverages update = new HotBeverages.Builder()
                .copy(currentDrink)
                .name(coldBeverages.getName())
                .price(coldBeverages.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<HotBeverages>(update,HttpStatus.OK);
    }

    /*
        DELETE HotDrink
    * */
    @RequestMapping(value = "/hotDrink/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<HotBeverages> deleteColdDrink(@PathVariable("id") long id)
    {
        HotBeverages beverage = service.readById(id);
        if(beverage == null)
        {
            return new ResponseEntity<HotBeverages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(beverage);
        return new ResponseEntity<HotBeverages>(HttpStatus.NO_CONTENT);
    }
}
