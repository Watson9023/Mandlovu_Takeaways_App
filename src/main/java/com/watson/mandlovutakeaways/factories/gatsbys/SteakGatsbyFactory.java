package com.watson.mandlovutakeaways.factories.gatsbys;


import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsby;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakGatsbyFactory
{
    public static SteakGatsby getSteakGatsby(String name, String price)
    {
        SteakGatsby gatsby = new SteakGatsby.Builder()
                .name(name)
                .price(price)
                .build();
        return gatsby;
    }
}
