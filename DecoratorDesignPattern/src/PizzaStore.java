import Pizza.BasePizza;
import Pizza.VolcanoPizza;
import Topping.ChickenSossage;
import Topping.ExtraCheese;

public class PizzaStore {
    public static void main(String[] args) {
        BasePizza pizza = new ChickenSossage(new ExtraCheese(new VolcanoPizza()));
        System.out.println("Total cost: " + pizza.cost());

    }
}
