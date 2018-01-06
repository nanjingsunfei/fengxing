package cn.njupt.factoryMode.creator;

import cn.njupt.factoryMode.pizza.Pizza;

/**
 * Created by sunfei on 2017/11/26.
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
