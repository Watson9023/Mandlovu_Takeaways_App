package com.watson.mandlovutakeaways.restclient.burgers;


import com.watson.mandlovutakeaways.domain.burgers.VeggyBurger;
import com.watson.mandlovutakeaways.services.burgers.VeggyBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class VeggyBurgerController
{
    @Autowired
    private VeggyBurgerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/veggyBurger/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VeggyBurger> createColdDrink(@RequestBody VeggyBurger veggyBurger) {
        service.create(veggyBurger);
        return new ResponseEntity<VeggyBurger>(veggyBurger, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/veggyBurger/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<VeggyBurger> readColdDrinkByID(@PathVariable("id") long id) {
        VeggyBurger drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<VeggyBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<VeggyBurger>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/veggyBurgers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<VeggyBurger>> findAllColdDrinks() {
        Iterable<VeggyBurger> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<VeggyBurger>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<VeggyBurger>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/veggyBurger/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VeggyBurger> updateColdDrink(@PathVariable("id") long id, @RequestBody VeggyBurger veggyBurger)
    {
        VeggyBurger currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<VeggyBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        VeggyBurger update = new VeggyBurger.Builder()
                .copy(currentBurger)
                .name(veggyBurger.getName())
                .price(veggyBurger.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<VeggyBurger>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/veggyBurger/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<VeggyBurger> deleteColdDrink(@PathVariable("id") long id)
    {
        VeggyBurger burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<VeggyBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<VeggyBurger>(HttpStatus.NO_CONTENT);
    }
}
