package com.watson.mandlovutakeaways.restclient.burgers;


import com.watson.mandlovutakeaways.domain.burgers.CheeseBurger;
import com.watson.mandlovutakeaways.services.burgers.CheeseBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class CheeseBurgerController
{
    @Autowired
    private CheeseBurgerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/cheeseBurger/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheeseBurger> createColdDrink(@RequestBody CheeseBurger cheeseBurger) {
        service.create(cheeseBurger);
        return new ResponseEntity<CheeseBurger>(cheeseBurger, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/cheeseBurger/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CheeseBurger> readColdDrinkByID(@PathVariable("id") long id) {
        CheeseBurger drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<CheeseBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CheeseBurger>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/cheeseBurgers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CheeseBurger>> findAllColdDrinks() {
        Iterable<CheeseBurger> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<CheeseBurger>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<CheeseBurger>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/cheeseBurger/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheeseBurger> updateColdDrink(@PathVariable("id") long id, @RequestBody CheeseBurger cheeseBurger)
    {
        CheeseBurger currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<CheeseBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CheeseBurger update = new CheeseBurger.Builder()
                .copy(currentBurger)
                .name(cheeseBurger.getName())
                .price(cheeseBurger.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<CheeseBurger>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/cheeseBurger/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CheeseBurger> deleteColdDrink(@PathVariable("id") long id)
    {
        CheeseBurger burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<CheeseBurger>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<CheeseBurger>(HttpStatus.NO_CONTENT);
    }
}
