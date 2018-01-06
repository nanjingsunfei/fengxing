package cn.njupt.factoryMode.ingredientFactory;

import cn.njupt.factoryMode.ingredient.Cheese;
import cn.njupt.factoryMode.ingredient.Clams;
import cn.njupt.factoryMode.ingredient.Dough;
import cn.njupt.factoryMode.ingredient.Pepperoni;
import cn.njupt.factoryMode.ingredient.Sauce;
import cn.njupt.factoryMode.ingredient.Veggies;

/**
 * Created by sunfei on 2017/11/26.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return null;
    }

    public Sauce createSauce() {
        return null;
    }

    public Cheese createCheese() {
        return null;
    }

    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    public Pepperoni createPepperoni() {
        return null;
    }

    public Clams createClams() {
        return null;
    }
}
