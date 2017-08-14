package com.watson.mandlovutakeaways.services.beverages.impl;


import com.watson.mandlovutakeaways.domain.beverages.HotBeverages;
import com.watson.mandlovutakeaways.repository.beverages.HotBeverageRepository;
import com.watson.mandlovutakeaways.services.beverages.HotBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Long on 8/14/2017.
 */
@Service
public class HotBeverageServiceImpl implements HotBeverageService {

    @Autowired
    private HotBeverageRepository repository;

    @Override
    public HotBeverages create(HotBeverages entity) {
        return repository.save(entity);
    }

    @Override
    public HotBeverages readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<HotBeverages> readAll() {
        Iterable<HotBeverages> result = repository.findAll();
        return result;
    }

    @Override
    public HotBeverages update(HotBeverages entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(HotBeverages entity) {
        repository.delete(entity);
    }
}
