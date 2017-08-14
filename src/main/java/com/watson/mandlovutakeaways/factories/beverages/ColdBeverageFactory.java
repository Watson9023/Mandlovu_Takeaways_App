package com.watson.mandlovutakeaways.factories.beverages;


import com.watson.mandlovutakeaways.domain.beverages.ColdBeverages;

/**
 * Created by Long on 8/14/2017.
 */
public class ColdBeverageFactory {

    public static ColdBeverages getColdBeverage(String name, String price)
    {
        ColdBeverages coldBeverages = new ColdBeverages.Builder()
                .name(name)
                .price(price)
                .build();
        return coldBeverages;
    }
}
