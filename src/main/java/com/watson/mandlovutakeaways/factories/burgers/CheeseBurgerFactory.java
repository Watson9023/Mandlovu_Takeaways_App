package com.watson.mandlovutakeaways.factories.burgers;


import com.watson.mandlovutakeaways.domain.burgers.CheeseBurger;

/**
 * Created by Long on 8/14/2017.
 */
public class CheeseBurgerFactory
{
    public static CheeseBurger getCheeseBurger(String name, String price)
    {
        CheeseBurger burger = new CheeseBurger.Builder()
                .name(name)
                .price(price)
                .build();
        return burger;
    }
}
