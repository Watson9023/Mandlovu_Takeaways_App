package com.watson.mandlovutakeaways.services.burgers.impl;


import com.watson.mandlovutakeaways.domain.burgers.BeefBurgers;
import com.watson.mandlovutakeaways.repository.burgers.BeefBurgerRepository;
import com.watson.mandlovutakeaways.services.burgers.BeefBurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class BeefBurgerServiceImpl implements BeefBurgerService {

    @Autowired
    private BeefBurgerRepository repository;

    @Override
    public BeefBurgers create(BeefBurgers entity) {
        return repository.save(entity);
    }

    @Override
    public BeefBurgers readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<BeefBurgers> readAll() {
        Iterable<BeefBurgers> result = repository.findAll();
        return result;
    }

    @Override
    public BeefBurgers update(BeefBurgers entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(BeefBurgers entity) {
        repository.delete(entity);
    }
}
