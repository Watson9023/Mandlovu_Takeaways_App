package com.watson.mandlovutakeaways.factories.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsby;

/**
 * Created by Long on 8/14/2017.
 */
public class PolonyGatsbyFactory
{
    public static PolonyGatsby getPolonyGatsby(String name, String price)
    {
        PolonyGatsby gatsby = new PolonyGatsby.Builder()
                .name(name)
                .price(price)
                .build();
        return gatsby;
    }
}
