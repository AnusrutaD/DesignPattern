package Topping;

import Pizza.BasePizza;

public class ChickenSossage extends ToppingDecorator{

    BasePizza basePizza;

    public ChickenSossage(BasePizza pizza){
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 60;
    }
}
