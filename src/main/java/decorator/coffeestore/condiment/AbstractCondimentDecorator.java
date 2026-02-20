package decorator.coffeestore.condiment;

import decorator.coffeestore.coffee.AbstractBeverage;

public abstract class AbstractCondimentDecorator extends AbstractBeverage {
    protected AbstractBeverage beverage;

    public AbstractCondimentDecorator(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
}
