package com.watson.mandlovutakeaways.restclient.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsby;
import com.watson.mandlovutakeaways.services.gatsbys.SteakGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class SteakGatsbyController
{
    @Autowired
    private SteakGatsbyService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/steakGatsby/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SteakGatsby> createColdDrink(@RequestBody SteakGatsby steakGatsby) {
        service.create(steakGatsby);
        return new ResponseEntity<SteakGatsby>(steakGatsby, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/steakGatsby/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SteakGatsby> readColdDrinkByID(@PathVariable("id") long id) {
        SteakGatsby drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<SteakGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<SteakGatsby>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/steakGatsbys/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SteakGatsby>> findAllColdDrinks() {
        Iterable<SteakGatsby> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<SteakGatsby>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<SteakGatsby>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/steakGatsby/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SteakGatsby> updateColdDrink(@PathVariable("id") long id, @RequestBody SteakGatsby steakGatsby)
    {
        SteakGatsby currentGatsby = service.readById(id);
        if(currentGatsby == null)
        {
            return new ResponseEntity<SteakGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        SteakGatsby update = new SteakGatsby.Builder()
                .copy(currentGatsby)
                .name(steakGatsby.getName())
                .price(steakGatsby.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<SteakGatsby>(update,HttpStatus.OK);
    }

    /*
        DELETE Burger
    * */
    @RequestMapping(value = "/steakGatsby/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<SteakGatsby> deleteColdDrink(@PathVariable("id") long id)
    {
        SteakGatsby burger = service.readById(id);
        if(burger == null)
        {
            return new ResponseEntity<SteakGatsby>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(burger);
        return new ResponseEntity<SteakGatsby>(HttpStatus.NO_CONTENT);
    }
}
