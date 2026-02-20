package decorator.coffeestore.coffee;

public class Espresso extends AbstractBeverage {
    public Espresso() {
        description = "espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}