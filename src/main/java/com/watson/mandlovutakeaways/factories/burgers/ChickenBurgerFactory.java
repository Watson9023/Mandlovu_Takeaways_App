package com.watson.mandlovutakeaways.factories.burgers;


import com.watson.mandlovutakeaways.domain.burgers.ChickenBurgers;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenBurgerFactory
{
    public static ChickenBurgers getChickenburger(String name, String price)
    {
        ChickenBurgers burger = new ChickenBurgers.Builder()
                .name(name)
                .price(price)
                .build();
        return burger;
    }
}
