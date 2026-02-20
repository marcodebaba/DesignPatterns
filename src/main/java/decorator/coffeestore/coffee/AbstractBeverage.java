package decorator.coffeestore.coffee;

import lombok.Getter;

@Getter
public abstract class AbstractBeverage {
    protected String description = "Abstract Beverage";

    public abstract double cost();
}