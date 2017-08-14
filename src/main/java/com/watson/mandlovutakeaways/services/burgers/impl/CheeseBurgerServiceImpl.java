package com.watson.mandlovutakeaways.services.burgers.impl;


import com.watson.mandlovutakeaways.domain.burgers.CheeseBurger;
import com.watson.mandlovutakeaways.repository.burgers.CheeseBurgerRepository;
import com.watson.mandlovutakeaways.services.burgers.CheeseBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class CheeseBurgerServiceImpl implements CheeseBurgerService {

    @Autowired
    private CheeseBurgerRepository repository;

    @Override
    public CheeseBurger create(CheeseBurger entity) {
        return repository.save(entity);
    }

    @Override
    public CheeseBurger readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<CheeseBurger> readAll() {
        Iterable<CheeseBurger> result = repository.findAll();
        return result;
    }

    @Override
    public CheeseBurger update(CheeseBurger entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(CheeseBurger entity) {
        repository.delete(entity);
    }
}
