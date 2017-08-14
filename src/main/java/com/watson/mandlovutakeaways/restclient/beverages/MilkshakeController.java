package com.watson.mandlovutakeaways.restclient.beverages;


import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;
import com.watson.mandlovutakeaways.services.beverages.MilkshakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Long on 8/14/2017.
 */
@RestController
public class MilkshakeController
{
    @Autowired
    private MilkshakeService service;

    /*
        CREATE
     */
    @RequestMapping(value = "/milkshake/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public ResponseEntity<Milkshakes> createColdDrink(@RequestBody Milkshakes milkshakes) {
        service.create(milkshakes);
        return new ResponseEntity<Milkshakes>(milkshakes, HttpStatus.CREATED);
    }

    /*
        READ SINGLE Drink
    * */
    @RequestMapping(value = "/milkshake/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Milkshakes> readColdDrinkByID(@PathVariable("id") long id) {
        Milkshakes drink = service.readById(id);
        if (drink == null) {
            return new ResponseEntity<Milkshakes>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Milkshakes>(drink, HttpStatus.OK);
    }

    /*
        READ ALL
      */
    @RequestMapping(value = "/milkshakes/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Milkshakes>> findAllColdDrinks() {
        Iterable<Milkshakes> coldBeverages = service.readAll();
        if (coldBeverages == null) {
            return new ResponseEntity<Iterable<Milkshakes>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Iterable<Milkshakes>>(coldBeverages, HttpStatus.OK);
    }

    /*
        UPDATE
    * */
    @RequestMapping(value = "/milkshake/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public ResponseEntity<Milkshakes> updateColdDrink(@PathVariable("id") long id, @RequestBody Milkshakes milkshakes)
    {
        Milkshakes currentDrink = service.readById(id);
        if(currentDrink == null)
        {
            return new ResponseEntity<Milkshakes>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Milkshakes update = new Milkshakes.Builder()
                .copy(currentDrink)
                .name(milkshakes.getName())
                .price(milkshakes.getPrice())
                .build();
        service.update(update);
        return new ResponseEntity<Milkshakes>(update,HttpStatus.OK);
    }

    /*
        DELETE HotDrink
    * */
    @RequestMapping(value = "/milkshake/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Milkshakes> deleteColdDrink(@PathVariable("id") long id)
    {
        Milkshakes beverage = service.readById(id);
        if(beverage == null)
        {
            return new ResponseEntity<Milkshakes>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(beverage);
        return new ResponseEntity<Milkshakes>(HttpStatus.NO_CONTENT);
    }
}
