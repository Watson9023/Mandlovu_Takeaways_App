package com.watson.mandlovutakeaways.restclient.burgers;


import com.watson.mandlovutakeaways.domain.burgers.BeefBurgers;
import com.watson.mandlovutakeaways.services.burgers.BeefBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class BeefBurgerController
{
    @Autowired
    private BeefBurgerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/beefBurger/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeefBurgers> createColdDrink(@RequestBody BeefBurgers beefBurgers) {
        service.create(beefBurgers);
        return new ResponseEntity<BeefBurgers>(beefBurgers, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/beefBurger/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BeefBurgers> readColdDrinkByID(@PathVariable("id") long id) {
        BeefBurgers drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<BeefBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<BeefBurgers>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/beefBurgers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<BeefBurgers>> findAllColdDrinks() {
        Iterable<BeefBurgers> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<BeefBurgers>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<BeefBurgers>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/beefBurger/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeefBurgers> updateColdDrink(@PathVariable("id") long id, @RequestBody BeefBurgers beefBurgers)
    {
        BeefBurgers currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<BeefBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BeefBurgers update = new BeefBurgers.Builder()
                .copy(currentBurger)
                .name(beefBurgers.getName())
                .price(beefBurgers.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<BeefBurgers>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/beefBurger/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<BeefBurgers> deleteColdDrink(@PathVariable("id") long id)
    {
        BeefBurgers burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<BeefBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<BeefBurgers>(HttpStatus.NO_CONTENT);
    }
}
