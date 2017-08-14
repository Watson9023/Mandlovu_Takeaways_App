package com.watson.mandlovutakeaways.restclient.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import com.watson.mandlovutakeaways.services.gatsbys.PolonyGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class PolonyGatsbyController
{
    @Autowired
    private PolonyGatsbyService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/polonyGatsby/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PolonyGatsby> createColdDrink(@RequestBody PolonyGatsby polonyGatsby) {
        service.create(polonyGatsby);
        return new ResponseEntity<PolonyGatsby>(polonyGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/polonyGatsby/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PolonyGatsby> readColdDrinkByID(@PathVariable("id") long id) {
        PolonyGatsby drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<PolonyGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<PolonyGatsby>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/polonyGatsbys/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PolonyGatsby>> findAllColdDrinks() {
        Iterable<PolonyGatsby> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<PolonyGatsby>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<PolonyGatsby>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/polonyGatsby/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PolonyGatsby> updateColdDrink(@PathVariable("id") long id, @RequestBody PolonyGatsby polonyGatsby)
    {
        PolonyGatsby currentGatsby = service.readById(id);
        if(currentGatsby == null)
        {
            return new ResponseEntity<PolonyGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PolonyGatsby update = new PolonyGatsby.Builder()
                .copy(currentGatsby)
                .name(polonyGatsby.getName())
                .price(polonyGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<PolonyGatsby>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/polonyGatsby/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<PolonyGatsby> deleteColdDrink(@PathVariable("id") long id)
    {
        PolonyGatsby burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<PolonyGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<PolonyGatsby>(HttpStatus.NO_CONTENT);
    }
}
