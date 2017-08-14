package com.watson.mandlovutakeaways.repository.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Long on 8/14/2017.
 */
@Repository
public interface SteakPizzaRepository extends CrudRepository<SteakPizza,Long> {
}
