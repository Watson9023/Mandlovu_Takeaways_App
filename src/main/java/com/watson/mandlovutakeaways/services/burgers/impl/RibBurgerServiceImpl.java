package com.watson.mandlovutakeaways.services.burgers.impl;


import com.watson.mandlovutakeaways.domain.burgers.RibBurger;
import com.watson.mandlovutakeaways.repository.burgers.RibBurgerRepository;
import com.watson.mandlovutakeaways.services.burgers.RibBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class RibBurgerServiceImpl implements RibBurgerService {

    @Autowired
    private RibBurgerRepository repository;

    @Override
    public RibBurger create(RibBurger entity) {
        return repository.save(entity);
    }

    @Override
    public RibBurger readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<RibBurger> readAll() {
        Iterable<RibBurger> result = repository.findAll();
        return result;
    }

    @Override
    public RibBurger update(RibBurger entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(RibBurger entity) {
        repository.delete(entity);
    }
}
