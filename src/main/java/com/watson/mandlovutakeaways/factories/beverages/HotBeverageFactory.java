package com.watson.mandlovutakeaways.factories.beverages;
import com.watson.mandlovutakeaways.domain.beverages.HotBeverages;

/**
 * Created by Long on 8/14/2017.
 */

public class HotBeverageFactory
{
    public static HotBeverages getHotBeverage(String name, String price)
    {
        HotBeverages hotBeverages = new HotBeverages.Builder()
                .name(name)
                .price(price)
                .build();
        return hotBeverages;
    }
}
