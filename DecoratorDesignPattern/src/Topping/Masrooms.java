package Topping;

import Pizza.BasePizza;

public class Masrooms extends ToppingDecorator{

    BasePizza basePizza;

    public Masrooms(BasePizza pizza){
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}
