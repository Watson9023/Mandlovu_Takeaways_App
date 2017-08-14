package com.watson.mandlovutakeaways.repository.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Long on 8/14/2017.
 */
@Repository
public interface PolonyGatsbyRepository extends CrudRepository<PolonyGatsby,Long> {
}
