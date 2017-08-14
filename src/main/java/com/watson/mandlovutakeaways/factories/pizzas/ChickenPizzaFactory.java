package com.watson.mandlovutakeaways.factories.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.ChickenPizza;

/**
 * Created by Long on 8/14/2017.
 */
public class ChickenPizzaFactory
{
    public static ChickenPizza getChickenPizza(String name, String price)
    {
        ChickenPizza pizza = new ChickenPizza.Builder()
                .name(name)
                .price(price)
                .build();
        return pizza;
    }
}
