package com.watson.mandlovutakeaways.factories.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizza;

/**
 * Created by Long on 8/14/2017.
 */
public class MexicanPizzaFactory
{
    public static MexicanPizza getMexicanPizza(String name, String price)
    {
        MexicanPizza pizza = new MexicanPizza.Builder()
                .name(name)
                .price(price)
                .build();
        return pizza;
    }
}
