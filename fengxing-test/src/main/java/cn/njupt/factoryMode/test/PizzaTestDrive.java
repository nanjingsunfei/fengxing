package cn.njupt.factoryMode.test;

import cn.njupt.factoryMode.creator.ChicagoPizzaStore;
import cn.njupt.factoryMode.creator.NYPizzaStore;
import cn.njupt.factoryMode.creator.PizzaStore;
import cn.njupt.factoryMode.pizza.Pizza;

/**
 * Created by sunfei on 2017/11/26.
 */
public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan order a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel order a " + pizza.getName() + "\n");
    }
}
