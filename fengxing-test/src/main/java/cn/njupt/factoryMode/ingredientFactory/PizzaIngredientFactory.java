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
public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();
}
