package com.watson.mandlovutakeaways.restclient.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;
import com.watson.mandlovutakeaways.services.pizzas.SteakPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class SteakPizzaController
{
    @Autowired
    private SteakPizzaService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/steakPizza/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SteakPizza> createColdDrink(@RequestBody SteakPizza chickenGatsby) {
        service.create(chickenGatsby);
        return new ResponseEntity<SteakPizza>(chickenGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/steakPizza/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SteakPizza> readColdDrinkByID(@PathVariable("id") long id) {
        SteakPizza drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<SteakPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SteakPizza>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/steakPizzas/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SteakPizza>> findAllColdDrinks() {
        Iterable<SteakPizza> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<SteakPizza>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<SteakPizza>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/steakPizza/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SteakPizza> updateColdDrink(@PathVariable("id") long id, @RequestBody SteakPizza chickenGatsby)
    {
        SteakPizza currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<SteakPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SteakPizza update = new SteakPizza.Builder()
                .copy(currentBurger)
                .name(chickenGatsby.getName())
                .price(chickenGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<SteakPizza>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/steakPizza/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SteakPizza> deleteColdDrink(@PathVariable("id") long id)
    {
        SteakPizza burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<SteakPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<SteakPizza>(HttpStatus.NO_CONTENT);
    }
}
