package com.watson.mandlovutakeaways.repository.burgers;

import com.watson.mandlovutakeaways.domain.burgers.VeggyBurger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Long on 8/14/2017.
 */
@Repository
public interface VeggyBurgerRepository extends CrudRepository<VeggyBurger,Long> {
}
