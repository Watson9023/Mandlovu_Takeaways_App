package com.watson.mandlovutakeaways.services.burgers.impl;


import com.watson.mandlovutakeaways.domain.burgers.ChickenBurgers;
import com.watson.mandlovutakeaways.repository.burgers.ChickenBurgerRepository;
import com.watson.mandlovutakeaways.services.burgers.ChickenBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class ChickenBurgerServiceImpl implements ChickenBurgerService {

    @Autowired
    private ChickenBurgerRepository repository;

    @Override
    public ChickenBurgers create(ChickenBurgers entity) {
        return repository.save(entity);
    }

    @Override
    public ChickenBurgers readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<ChickenBurgers> readAll() {
        Iterable<ChickenBurgers> result = repository.findAll();
        return result;
    }

    @Override
    public ChickenBurgers update(ChickenBurgers entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ChickenBurgers entity) {
        repository.delete(entity);
    }
}
