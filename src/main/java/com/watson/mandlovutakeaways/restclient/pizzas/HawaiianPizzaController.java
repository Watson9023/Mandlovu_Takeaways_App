package com.watson.mandlovutakeaways.restclient.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizza;
import com.watson.mandlovutakeaways.services.pizzas.HawaiianPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class HawaiianPizzaController
{
    @Autowired
    private HawaiianPizzaService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/hawaiianPizza/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HawaiianPizza> createColdDrink(@RequestBody HawaiianPizza chickenGatsby) {
        service.create(chickenGatsby);
        return new ResponseEntity<HawaiianPizza>(chickenGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/hawaiianPizza/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HawaiianPizza> readColdDrinkByID(@PathVariable("id") long id) {
        HawaiianPizza drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<HawaiianPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HawaiianPizza>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/hawaiianPizzas/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<HawaiianPizza>> findAllColdDrinks() {
        Iterable<HawaiianPizza> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<HawaiianPizza>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<HawaiianPizza>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/hawaiianPizza/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HawaiianPizza> updateColdDrink(@PathVariable("id") long id, @RequestBody HawaiianPizza chickenGatsby)
    {
        HawaiianPizza currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<HawaiianPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        HawaiianPizza update = new HawaiianPizza.Builder()
                .copy(currentBurger)
                .name(chickenGatsby.getName())
                .price(chickenGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<HawaiianPizza>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/hawaiianPizza/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<HawaiianPizza> deleteColdDrink(@PathVariable("id") long id)
    {
        HawaiianPizza burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<HawaiianPizza>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<HawaiianPizza>(HttpStatus.NO_CONTENT);
    }
}
