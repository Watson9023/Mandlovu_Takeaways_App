package com.watson.mandlovutakeaways.factories.burgers;


import com.watson.mandlovutakeaways.domain.burgers.VeggyBurger;

/**
 * Created by Long on 8/14/2017.
 */
public class VeggyBurgerFactory
{
    public static VeggyBurger getVeggyBurger(String name, String price)
    {
        VeggyBurger burger = new VeggyBurger.Builder()
                .name(name)
                .price(price)
                .build();
        return burger;
    }
}
