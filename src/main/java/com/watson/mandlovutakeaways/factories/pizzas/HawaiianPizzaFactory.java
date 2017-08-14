package com.watson.mandlovutakeaways.factories.pizzas;


import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizza;

/**
 * Created by Long on 8/14/2017.
 */
public class HawaiianPizzaFactory
{
    public static HawaiianPizza getHawaiianPizza(String name, String price)
    {
        HawaiianPizza pizza = new HawaiianPizza.Builder()
                .name(name)
                .price(price)
                .build();
        return pizza;
    }
}
