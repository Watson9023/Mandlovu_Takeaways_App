package com.watson.mandlovutakeaways.services.gatsbys.impl;


import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsby;
import com.watson.mandlovutakeaways.repository.gatsbys.SteakGatsbyRepository;
import com.watson.mandlovutakeaways.services.gatsbys.SteakGatsbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class SteakGatsbyServiceImpl implements SteakGatsbyService {

    @Autowired
    private SteakGatsbyRepository repository;

    @Override
    public SteakGatsby create(SteakGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public SteakGatsby readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<SteakGatsby> readAll() {
        Iterable<SteakGatsby> result = repository.findAll();
        return result;
    }

    @Override
    public SteakGatsby update(SteakGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(SteakGatsby entity) {
        repository.delete(entity);
    }
}
