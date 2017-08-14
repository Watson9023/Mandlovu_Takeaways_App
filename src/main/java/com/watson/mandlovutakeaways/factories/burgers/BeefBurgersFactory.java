package com.watson.mandlovutakeaways.factories.burgers;


import com.watson.mandlovutakeaways.domain.burgers.BeefBurgers;

/**
 * Created by Long on 8/14/2017.
 */
public class BeefBurgersFactory
{
    public static BeefBurgers getBeefBurger(String name, String price)
    {
        BeefBurgers burger = new BeefBurgers.Builder()
                .name(name)
                .price(price)
                .build();
        return burger;
    }
}
