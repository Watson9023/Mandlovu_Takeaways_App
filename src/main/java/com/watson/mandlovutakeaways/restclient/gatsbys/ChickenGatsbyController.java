package com.watson.mandlovutakeaways.restclient.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsby;
import com.watson.mandlovutakeaways.services.gatsbys.ChickenGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class ChickenGatsbyController
{
    @Autowired
    private ChickenGatsbyService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/chickenGatsby/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenGatsby> createColdDrink(@RequestBody ChickenGatsby chickenGatsby) {
        service.create(chickenGatsby);
        return new ResponseEntity<ChickenGatsby>(chickenGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/chickenGatsby/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ChickenGatsby> readColdDrinkByID(@PathVariable("id") long id) {
        ChickenGatsby drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<ChickenGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ChickenGatsby>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/chickenGatsbys/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ChickenGatsby>> findAllColdDrinks() {
        Iterable<ChickenGatsby> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<ChickenGatsby>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<ChickenGatsby>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/chickenGatsby/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChickenGatsby> updateColdDrink(@PathVariable("id") long id, @RequestBody ChickenGatsby chickenGatsby)
    {
        ChickenGatsby currentBurger = service.readById(id);
        if(currentBurger == null)
        {
            return new ResponseEntity<ChickenGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ChickenGatsby update = new ChickenGatsby.Builder()
                .copy(currentBurger)
                .name(chickenGatsby.getName())
                .price(chickenGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<ChickenGatsby>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/chickenGatsby/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<ChickenGatsby> deleteColdDrink(@PathVariable("id") long id)
    {
        ChickenGatsby burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<ChickenGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<ChickenGatsby>(HttpStatus.NO_CONTENT);
    }
}
