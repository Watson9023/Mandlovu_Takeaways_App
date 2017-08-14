package com.watson.mandlovutakeaways.restclient.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsby;
import com.watson.mandlovutakeaways.services.gatsbys.FullhouseGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class FullhouseGatsbyController
{
    @Autowired
    private FullhouseGatsbyService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/fullhouseGastby/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FullhouseGatsby> createColdDrink(@RequestBody FullhouseGatsby fullhouseGatsby) {
        service.create(fullhouseGatsby);
        return new ResponseEntity<FullhouseGatsby>(fullhouseGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/fullhouseGatsby/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FullhouseGatsby> readColdDrinkByID(@PathVariable("id") long id) {
        FullhouseGatsby drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<FullhouseGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FullhouseGatsby>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/fullhouseGatsbys/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<FullhouseGatsby>> findAllColdDrinks() {
        Iterable<FullhouseGatsby> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<FullhouseGatsby>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<FullhouseGatsby>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/fullhouseGatsby/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FullhouseGatsby> updateColdDrink(@PathVariable("id") long id, @RequestBody FullhouseGatsby fullhouseGatsby)
    {
        FullhouseGatsby currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<FullhouseGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        FullhouseGatsby update = new FullhouseGatsby.Builder()
                .copy(currentBurger)
                .name(fullhouseGatsby.getName())
                .price(fullhouseGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<FullhouseGatsby>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/fullhouseGatsby/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<FullhouseGatsby> deleteColdDrink(@PathVariable("id") long id)
    {
        FullhouseGatsby burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<FullhouseGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<FullhouseGatsby>(HttpStatus.NO_CONTENT);
    }
}
