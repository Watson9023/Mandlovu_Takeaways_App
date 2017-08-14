package com.watson.mandlovutakeaways.factories.burgers;


import com.watson.mandlovutakeaways.domain.burgers.RibBurger;

/**
 * Created by Long on 8/14/2017.
 */
public class RibBurgerFactory
{
    public static RibBurger getRibBurger(String name, String price)
    {
        RibBurger burger = new RibBurger.Builder()
                .name(name)
                .price(price)
                .build();
        return burger;
    }
}
