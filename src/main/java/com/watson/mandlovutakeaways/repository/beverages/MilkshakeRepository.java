package com.watson.mandlovutakeaways.repository.beverages;


import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Long on 8/14/2017.
 */
@Repository
public interface MilkshakeRepository extends CrudRepository<Milkshakes,Long> {
}
