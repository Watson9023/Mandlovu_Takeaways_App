package com.watson.mandlovutakeaways.services.pizzas.impl;


import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizza;
import com.watson.mandlovutakeaways.repository.pizzas.MexicanPizzaRepository;
import com.watson.mandlovutakeaways.services.pizzas.MexicanPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class MexicanPizzaServiceImpl implements MexicanPizzaService {

    @Autowired
    private MexicanPizzaRepository repository;

    @Override
    public MexicanPizza create(MexicanPizza entity) {
        return repository.save(entity) ;
    }

    @Override
    public MexicanPizza readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<MexicanPizza> readAll() {
        Iterable<MexicanPizza> result = repository.findAll();
        return result;
    }

    @Override
    public MexicanPizza update(MexicanPizza entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(MexicanPizza entity) {
        repository.delete(entity);
    }
}
