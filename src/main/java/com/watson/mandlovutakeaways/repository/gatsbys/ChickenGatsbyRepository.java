package com.watson.mandlovutakeaways.repository.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Long on 8/14/2017.
 */
@Repository
public interface ChickenGatsbyRepository extends CrudRepository<ChickenGatsby,Long> {
}
