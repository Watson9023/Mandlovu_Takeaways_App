package com.watson.mandlovutakeaways.services.pizzas.impl;


import com.watson.mandlovutakeaways.domain.pizzas.ChickenPizza;
import com.watson.mandlovutakeaways.repository.pizzas.ChickenPizzaRepository;
import com.watson.mandlovutakeaways.services.pizzas.ChickenPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class ChickenPizzaServiceImpl implements ChickenPizzaService {

    @Autowired
    private ChickenPizzaRepository repository;

    @Override
    public ChickenPizza create(ChickenPizza entity) {
        return repository.save(entity);
    }

    @Override
    public ChickenPizza readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<ChickenPizza> readAll() {
        Iterable<ChickenPizza> result = repository.findAll();
        return result;
    }

    @Override
    public ChickenPizza update(ChickenPizza entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ChickenPizza entity) {
        repository.delete(entity);
    }
}
