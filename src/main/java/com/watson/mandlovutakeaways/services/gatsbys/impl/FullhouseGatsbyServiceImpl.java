package com.watson.mandlovutakeaways.services.gatsbys.impl;


import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsby;
import com.watson.mandlovutakeaways.repository.gatsbys.FullhouseGatsbysRepository;
import com.watson.mandlovutakeaways.services.gatsbys.FullhouseGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class FullhouseGatsbyServiceImpl implements FullhouseGatsbyService {

    @Autowired
    private FullhouseGatsbysRepository repository;

    @Override
    public FullhouseGatsby create(FullhouseGatsby entity) {
        return repository.save(entity) ;
    }

    @Override
    public FullhouseGatsby readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<FullhouseGatsby> readAll() {
        Iterable<FullhouseGatsby> result = repository.findAll();
        return result;
    }

    @Override
    public FullhouseGatsby update(FullhouseGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(FullhouseGatsby entity) {
        repository.delete(entity);
    }
}
