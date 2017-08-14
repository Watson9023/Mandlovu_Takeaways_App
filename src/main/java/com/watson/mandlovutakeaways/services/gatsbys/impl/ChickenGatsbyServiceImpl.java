package com.watson.mandlovutakeaways.services.gatsbys.impl;


import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsby;
import com.watson.mandlovutakeaways.repository.gatsbys.ChickenGatsbyRepository;
import com.watson.mandlovutakeaways.services.gatsbys.ChickenGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class ChickenGatsbyServiceImpl implements ChickenGatsbyService {

    @Autowired
    private ChickenGatsbyRepository repository;

    @Override
    public ChickenGatsby create(ChickenGatsby entity) {
        return repository.save(entity) ;
    }

    @Override
    public ChickenGatsby readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<ChickenGatsby> readAll() {
        Iterable<ChickenGatsby> result = repository.findAll();
        return result;
    }

    @Override
    public ChickenGatsby update(ChickenGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ChickenGatsby entity) {
        repository.delete(entity);
    }
}
