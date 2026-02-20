package decorator.coffeestore.condiment;

import decorator.coffeestore.coffee.AbstractBeverage;

public class Whip extends AbstractCondimentDecorator {

    public Whip(AbstractBeverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .41;
    }
}
