package com.watson.mandlovutakeaways.restclient.burgers;


import com.watson.mandlovutakeaways.domain.burgers.ChickenBurgers;
import com.watson.mandlovutakeaways.services.burgers.ChickenBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class ChickenBurgerController
{
    @Autowired
    private ChickenBurgerService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/chickenBurger/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenBurgers> creatChickenBurger(@RequestBody ChickenBurgers chickenBurger) {
        service.create(chickenBurger);
        return new ResponseEntity<ChickenBurgers>(chickenBurger, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/chickenBurger/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ChickenBurgers> readColdDrinkByID(@PathVariable("id") long id) {
        ChickenBurgers drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<ChickenBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ChickenBurgers>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/chickenBurgers/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ChickenBurgers>> findAllColdDrinks() {
        Iterable<ChickenBurgers> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<ChickenBurgers>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<ChickenBurgers>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/chickenBurger/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenBurgers> updateColdDrink(@PathVariable("id") long id, @RequestBody ChickenBurgers chickenBurgers)
    {
        ChickenBurgers currentDrink = service.readById(id);
        if(currentDrink == null)
        {
            return new ResponseEntity<ChickenBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ChickenBurgers update = new ChickenBurgers.Builder()
                .copy(currentDrink)
                .name(chickenBurgers.getName())
                .price(chickenBurgers.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<ChickenBurgers>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/chickenBurger/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ChickenBurgers> deleteColdDrink(@PathVariable("id") long id)
    {
        ChickenBurgers burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<ChickenBurgers>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<ChickenBurgers>(HttpStatus.NO_CONTENT);
    }
}
