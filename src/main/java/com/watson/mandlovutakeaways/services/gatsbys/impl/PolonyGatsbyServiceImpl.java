package com.watson.mandlovutakeaways.services.gatsbys.impl;


import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import com.watson.mandlovutakeaways.repository.gatsbys.PolonyGatsbyRepository;
import com.watson.mandlovutakeaways.services.gatsbys.PolonyGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class PolonyGatsbyServiceImpl implements PolonyGatsbyService {

    @Autowired
    private PolonyGatsbyRepository repository;

    @Override
    public PolonyGatsby create(PolonyGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public PolonyGatsby readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<PolonyGatsby> readAll() {
        Iterable<PolonyGatsby> result = repository.findAll();
        return result;
    }

    @Override
    public PolonyGatsby update(PolonyGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(PolonyGatsby entity) {
        repository.delete(entity);
    }
}
