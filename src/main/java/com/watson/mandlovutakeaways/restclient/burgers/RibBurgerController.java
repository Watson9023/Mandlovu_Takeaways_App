package com.watson.mandlovutakeaways.restclient.burgers;


import com.watson.mandlovutakeaways.domain.burgers.RibBurger;
import com.watson.mandlovutakeaways.services.burgers.RibBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class RibBurgerController
{
    @Autowired
    private RibBurgerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/ribBurger/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RibBurger> createColdDrink(@RequestBody RibBurger ribBurger) {
        service.create(ribBurger);
        return new ResponseEntity<RibBurger>(ribBurger, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/ribBurger/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RibBurger> readColdDrinkByID(@PathVariable("id") long id) {
        RibBurger drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<RibBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RibBurger>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/ribBurgers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<RibBurger>> findAllColdDrinks() {
        Iterable<RibBurger> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<RibBurger>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<RibBurger>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/ribBurger/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RibBurger> updateColdDrink(@PathVariable("id") long id, @RequestBody RibBurger ribBurger)
    {
        RibBurger currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<RibBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        RibBurger update = new RibBurger.Builder()
                .copy(currentBurger)
                .name(ribBurger.getName())
                .price(ribBurger.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<RibBurger>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/ribBurger/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<RibBurger> deleteColdDrink(@PathVariable("id") long id)
    {
        RibBurger burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<RibBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<RibBurger>(HttpStatus.NO_CONTENT);
    }
}
