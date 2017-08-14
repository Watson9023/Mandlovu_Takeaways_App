package com.watson.mandlovutakeaways.factories.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsby;

/**
 * Created by Long on 8/14/2017.
 */
public class FullhouseGatsbyFactory
{
    public static FullhouseGatsby getFullhouseGatsby(String name, String price)
    {
        FullhouseGatsby gatsby = new FullhouseGatsby.Builder()
                .name(name)
                .price(price)
                .build();
        return gatsby;
    }
}
