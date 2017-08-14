package com.watson.mandlovutakeaways.services.beverages.impl;


import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;
import com.watson.mandlovutakeaways.repository.beverages.MilkshakeRepository;
import com.watson.mandlovutakeaways.services.beverages.MilkshakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class MilkshakeServiceImpl implements MilkshakeService {

    @Autowired
    private MilkshakeRepository repository;

    @Override
    public Milkshakes create(Milkshakes entity) {
        return repository.save(entity);
    }

    @Override
    public Milkshakes readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Milkshakes> readAll() {
        Iterable<Milkshakes> result = repository.findAll();
        return result;
    }

    @Override
    public Milkshakes update(Milkshakes entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Milkshakes entity) {
        repository.delete(entity);
    }
}
