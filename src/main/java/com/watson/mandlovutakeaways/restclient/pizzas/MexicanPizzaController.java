package com.watson.mandlovutakeaways.restclient.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizza;
import com.watson.mandlovutakeaways.services.pizzas.MexicanPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class MexicanPizzaController
{
    @Autowired
    private MexicanPizzaService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/mexicanPizza/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MexicanPizza> createColdDrink(@RequestBody MexicanPizza chickenGatsby) {
        service.create(chickenGatsby);
        return new ResponseEntity<MexicanPizza>(chickenGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/mexicanPizza/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MexicanPizza> readColdDrinkByID(@PathVariable("id") long id) {
        MexicanPizza drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<MexicanPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<MexicanPizza>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/mexicanPizzas/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<MexicanPizza>> findAllColdDrinks() {
        Iterable<MexicanPizza> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<MexicanPizza>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<MexicanPizza>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/mexicanPizza/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MexicanPizza> updateColdDrink(@PathVariable("id") long id, @RequestBody MexicanPizza chickenGatsby)
    {
        MexicanPizza currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<MexicanPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MexicanPizza update = new MexicanPizza.Builder()
                .copy(currentBurger)
                .name(chickenGatsby.getName())
                .price(chickenGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<MexicanPizza>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/mexicanPizza/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<MexicanPizza> deleteColdDrink(@PathVariable("id") long id)
    {
        MexicanPizza burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<MexicanPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<MexicanPizza>(HttpStatus.NO_CONTENT);
    }
}
