package com.watson.mandlovutakeaways.services.pizzas.impl;


import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizza;
import com.watson.mandlovutakeaways.repository.pizzas.HawaiianPizzaRepository;
import com.watson.mandlovutakeaways.services.pizzas.HawaiianPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class HawaiianPizzaServiceImpl implements HawaiianPizzaService {

    @Autowired
    private HawaiianPizzaRepository repository;

    @Override
    public HawaiianPizza create(HawaiianPizza entity) {
        return repository.save(entity);
    }

    @Override
    public HawaiianPizza readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<HawaiianPizza> readAll() {
        Iterable<HawaiianPizza> result = repository.findAll();
        return result;
    }

    @Override
    public HawaiianPizza update(HawaiianPizza entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(HawaiianPizza entity) {
        repository.delete(entity);
    }
}
