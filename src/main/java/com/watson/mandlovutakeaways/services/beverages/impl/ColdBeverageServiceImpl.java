package com.watson.mandlovutakeaways.services.beverages.impl;


import com.watson.mandlovutakeaways.domain.beverages.ColdBeverages;
import com.watson.mandlovutakeaways.repository.beverages.ColdBeveragesRepository;
import com.watson.mandlovutakeaways.services.beverages.ColdBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class ColdBeverageServiceImpl implements ColdBeverageService {

    @Autowired
    private ColdBeveragesRepository repository;

    @Override
    public ColdBeverages create(ColdBeverages entity) {
        return repository.save(entity);
    }

    @Override
    public ColdBeverages readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<ColdBeverages> readAll() {
        Iterable<ColdBeverages> result = repository.findAll();
        return result;
    }

    @Override
    public ColdBeverages update(ColdBeverages entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ColdBeverages entity) {
        repository.delete(entity);
    }
}
