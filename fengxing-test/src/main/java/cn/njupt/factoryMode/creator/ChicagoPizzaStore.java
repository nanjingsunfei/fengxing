package cn.njupt.factoryMode.creator;

import cn.njupt.factoryMode.ingredientFactory.ChicagoPizzaIngredientFactory;
import cn.njupt.factoryMode.ingredientFactory.PizzaIngredientFactory;
import cn.njupt.factoryMode.pizza.CheesePizza;
import cn.njupt.factoryMode.pizza.ClamPizza;
import cn.njupt.factoryMode.pizza.Pizza;

/**
 * Created by sunfei on 2017/11/26.
 */
public class ChicagoPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }
}
