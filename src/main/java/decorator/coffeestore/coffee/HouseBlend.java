package decorator.coffeestore.coffee;

public class HouseBlend extends AbstractBeverage {
    public HouseBlend() {
        description = "house blend";
    }

    @Override
    public double cost() {
        return .89;
    }
}