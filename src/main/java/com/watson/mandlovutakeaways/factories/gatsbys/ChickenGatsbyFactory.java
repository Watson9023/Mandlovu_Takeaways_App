package com.watson.mandlovutakeaways.factories.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsby;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenGatsbyFactory
{
    public static ChickenGatsby getChickenGatsby(String name, String price)
    {
        ChickenGatsby gatsby = new ChickenGatsby.Builder()
                .name(name)
                .price(price)
                .build();
        return gatsby;
    }
}
