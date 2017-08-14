package com.watson.mandlovutakeaways.services.burgers.impl;


import com.watson.mandlovutakeaways.domain.burgers.VeggyBurger;
import com.watson.mandlovutakeaways.repository.burgers.VeggyBurgerRepository;
import com.watson.mandlovutakeaways.services.burgers.VeggyBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class VeggyBurgerServiceImpl implements VeggyBurgerService {

    @Autowired
    private VeggyBurgerRepository repository;

    @Override
    public VeggyBurger create(VeggyBurger entity) {
        return repository.save(entity);
    }

    @Override
    public VeggyBurger readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<VeggyBurger> readAll() {
        Iterable<VeggyBurger> result = repository.findAll();
        return result;
    }

    @Override
    public VeggyBurger update(VeggyBurger entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(VeggyBurger entity) {
        repository.delete(entity);
    }
}
