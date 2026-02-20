package decorator.coffeestore.condiment;

import decorator.coffeestore.coffee.AbstractBeverage;

public class Mocha extends AbstractCondimentDecorator {

    public Mocha(AbstractBeverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }
}
