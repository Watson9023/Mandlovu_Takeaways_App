package com.watson.mandlovutakeaways.factories.beverages;


import com.watson.mandlovutakeaways.domain.beverages.Milkshakes;

/**
 * Created by Long on 8/14/2017.
 */
public class MilkshakeFactory
{
    public static Milkshakes getMilkshake(String name, String price)
    {
        Milkshakes milkshakes = new Milkshakes.Builder()
                .name(name)
                .price(price)
                .build();
        return milkshakes;
    }
}
