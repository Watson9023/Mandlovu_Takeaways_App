package com.watson.mandlovutakeaways.restclient.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.ChickenPizza;
import com.watson.mandlovutakeaways.services.pizzas.ChickenPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class ChickenPizzaController
{
    @Autowired
    private ChickenPizzaService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/chickenPizza/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenPizza> createColdDrink(@RequestBody ChickenPizza chickenGatsby) {
        service.create(chickenGatsby);
        return new ResponseEntity<ChickenPizza>(chickenGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/chickenPizza/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ChickenPizza> readColdDrinkByID(@PathVariable("id") long id) {
        ChickenPizza drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<ChickenPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ChickenPizza>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/chickenPizzas/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ChickenPizza>> findAllColdDrinks() {
        Iterable<ChickenPizza> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<ChickenPizza>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<ChickenPizza>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/chickenPizza/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenPizza> updateColdDrink(@PathVariable("id") long id, @RequestBody ChickenPizza chickenGatsby)
    {
        ChickenPizza currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<ChickenPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ChickenPizza update = new ChickenPizza.Builder()
                .copy(currentBurger)
                .name(chickenGatsby.getName())
                .price(chickenGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<ChickenPizza>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/chickenPizza/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ChickenPizza> deleteColdDrink(@PathVariable("id") long id)
    {
        ChickenPizza burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<ChickenPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<ChickenPizza>(HttpStatus.NO_CONTENT);
    }
}
