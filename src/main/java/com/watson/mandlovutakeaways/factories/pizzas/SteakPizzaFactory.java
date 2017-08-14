package com.watson.mandlovutakeaways.factories.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.SteakPizza;

/**
 * Created by Long on 8/14/2017.
 */
public class SteakPizzaFactory
{
    public static SteakPizza getSteakPizza(String name, String price)
    {
        SteakPizza pizza = new SteakPizza.Builder()
                .name(name)
                .price(price)
                .build();
        return pizza;
    }
}
