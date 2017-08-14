package com.watson.mandlovutakeaways.services.pizzas.impl;


import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;
import com.watson.mandlovutakeaways.repository.pizzas.SteakPizzaRepository;
import com.watson.mandlovutakeaways.services.pizzas.SteakPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class SteakPizzaServiceImpl implements SteakPizzaService {

    @Autowired
    private SteakPizzaRepository repository;

    @Override
    public SteakPizza create(SteakPizza entity) {
        return repository.save(entity);
    }

    @Override
    public SteakPizza readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<SteakPizza> readAll() {
        Iterable<SteakPizza> result = repository.findAll();
        return result;
    }

    @Override
    public SteakPizza update(SteakPizza entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(SteakPizza entity) {
        repository.delete(entity);
    }
}
