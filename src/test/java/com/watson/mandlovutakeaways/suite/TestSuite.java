package com.watson.mandlovutakeaways.suite;

import com.watson.mandlovutakeaways.domain.beverages.ColdBeveragesTest;
import com.watson.mandlovutakeaways.domain.beverages.HotBeveragesTest;
import com.watson.mandlovutakeaways.domain.beverages.MilkshakesTest;
import com.watson.mandlovutakeaways.domain.burgers.*;
import com.watson.mandlovutakeaways.domain.gatsbys.ChickenGatsbyTest;
import com.watson.mandlovutakeaways.domain.pizzas.HawaiianPizzaTest;
import com.watson.mandlovutakeaways.domain.pizzas.MexicanPizzaTest;
import com.watson.mandlovutakeaways.domain.pizzas.SteakPizzaTest;
import com.watson.mandlovutakeaways.factories.beverages.ColdBeverageFactoryTest;
import com.watson.mandlovutakeaways.factories.beverages.HotBeverageFactoryTest;
import com.watson.mandlovutakeaways.factories.beverages.MilkshakeFactoryTest;
import com.watson.mandlovutakeaways.factories.burgers.*;
import com.watson.mandlovutakeaways.factories.gatsbys.ChickenGatsbyFactoryTest;
import com.watson.mandlovutakeaways.factories.gatsbys.FullhouseGatsbyFactoryTest;
import com.watson.mandlovutakeaways.factories.gatsbys.PolonyGatsbyFactoryTest;
import com.watson.mandlovutakeaways.factories.gatsbys.SteakGatsbyFactoryTest;
import com.watson.mandlovutakeaways.factories.pizzas.ChickenPizzaFactoryTest;
import com.watson.mandlovutakeaways.factories.pizzas.HawaiianPizzaFactoryTest;
import com.watson.mandlovutakeaways.factories.pizzas.MexicanPizzaFactoryTest;
import com.watson.mandlovutakeaways.factories.pizzas.SteakPizzaFactoryTest;
import com.watson.mandlovutakeaways.restclient.beverages.ColdBeverageControllerTest;
import com.watson.mandlovutakeaways.restclient.beverages.HotBeverageControllerTest;
import com.watson.mandlovutakeaways.restclient.beverages.MilkshakeControllerTest;
import com.watson.mandlovutakeaways.restclient.burgers.*;
import com.watson.mandlovutakeaways.restclient.gatsbys.ChickenGatsbyControllerTest;
import com.watson.mandlovutakeaways.restclient.gatsbys.FullhouseGatsbyControllerTest;
import com.watson.mandlovutakeaways.restclient.gatsbys.PolonyGatsbyControllerTest;
import com.watson.mandlovutakeaways.restclient.gatsbys.SteakGatsbyControllerTest;
import com.watson.mandlovutakeaways.restclient.pizzas.ChickenPizzaControllerTest;
import com.watson.mandlovutakeaways.restclient.pizzas.HawaiianPizzaControllerTest;
import com.watson.mandlovutakeaways.restclient.pizzas.MexicanPizzaControllerTest;
import com.watson.mandlovutakeaways.restclient.pizzas.SteakPizzaControllerTest;
import com.watson.mandlovutakeaways.services.beverages.impl.ColdBeverageServiceImplTest;
import com.watson.mandlovutakeaways.services.beverages.impl.HotBeverageServiceImplTest;
import com.watson.mandlovutakeaways.services.beverages.impl.MilkshakeServiceImplTest;
import com.watson.mandlovutakeaways.services.burgers.impl.*;
import com.watson.mandlovutakeaways.services.gatsbys.impl.ChickenGatsbyServiceImplTest;
import com.watson.mandlovutakeaways.services.gatsbys.impl.FullhouseGatsbyServiceImplTest;
import com.watson.mandlovutakeaways.services.gatsbys.impl.PolonyGatsbyServiceImplTest;
import com.watson.mandlovutakeaways.services.gatsbys.impl.SteakGatsbyServiceImplTest;
import com.watson.mandlovutakeaways.services.pizzas.impl.ChickenPizzaServiceImplTest;
import com.watson.mandlovutakeaways.services.pizzas.impl.HawaiianPizzaServiceImplTest;
import com.watson.mandlovutakeaways.services.pizzas.impl.MexicanPizzaServiceImplTest;
import com.watson.mandlovutakeaways.services.pizzas.impl.SteakPizzaServiceImplTest;
import com.watson.mandlovutakeaways.domain.gatsbys.FullhouseGatsbyTest;
import com.watson.mandlovutakeaways.domain.gatsbys.PolonyGatsbyTest;
import com.watson.mandlovutakeaways.domain.gatsbys.SteakGatsbyTest;
import com.watson.mandlovutakeaways.domain.pizzas.ChickenPizzaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Long on 8/14/2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
    {
        //domain
        ColdBeveragesTest.class, HotBeveragesTest.class, MilkshakesTest.class,
        BeefBurgersTest.class, CheeseBurgerTest.class, RibBurgerTest.class, VeggyBurgerTest.class, ChickenBurgersTest.class,
        ChickenGatsbyTest.class, FullhouseGatsbyTest.class, PolonyGatsbyTest.class, SteakGatsbyTest.class,
        ChickenPizzaTest.class, HawaiianPizzaTest.class, MexicanPizzaTest.class, SteakPizzaTest.class,

        //factories
        ColdBeverageFactoryTest.class, HotBeverageFactoryTest.class, MilkshakeFactoryTest.class,
        BeefBurgersFactoryTest.class, CheeseBurgerFactoryTest.class, RibBurgerFactoryTest.class, VeggyBurgerFactoryTest.class, ChickenBurgerFactoryTest.class,
        ChickenPizzaFactoryTest.class, HawaiianPizzaFactoryTest.class, MexicanPizzaFactoryTest.class, SteakPizzaFactoryTest.class,
        ChickenGatsbyFactoryTest.class, FullhouseGatsbyFactoryTest.class, PolonyGatsbyFactoryTest.class,SteakGatsbyFactoryTest.class,

        //Services
        ColdBeverageServiceImplTest.class, HotBeverageServiceImplTest.class, MilkshakeServiceImplTest.class,
        BeefBurgerServiceImplTest.class, CheeseBurgerServiceImplTest.class, ChickenBurgerServiceImplTest.class, RibBurgerServiceImplTest.class, VeggyBurgerServiceImplTest.class,
        ChickenGatsbyServiceImplTest.class, FullhouseGatsbyServiceImplTest.class, PolonyGatsbyServiceImplTest.class, SteakGatsbyServiceImplTest.class,
        ChickenPizzaServiceImplTest.class, HawaiianPizzaServiceImplTest.class, MexicanPizzaServiceImplTest.class, SteakPizzaServiceImplTest.class,

        //RestClients
        ColdBeverageControllerTest.class, HotBeverageControllerTest.class, MilkshakeControllerTest.class,
        BeefBurgerControllerTest.class, CheeseBurgerControllerTest.class, ChickenBurgerControllerTest.class, RibBurgerControllerTest.class, VeggyBurgerControllerTest.class,
        ChickenGatsbyControllerTest.class, FullhouseGatsbyControllerTest.class, PolonyGatsbyControllerTest.class, SteakGatsbyControllerTest.class,
        ChickenPizzaControllerTest.class, HawaiianPizzaControllerTest.class, MexicanPizzaControllerTest.class, SteakPizzaControllerTest.class
    }
)

public class TestSuite {
}
