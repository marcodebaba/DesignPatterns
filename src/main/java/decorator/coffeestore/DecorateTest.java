package decorator.coffeestore;

import decorator.coffeestore.coffee.Beverage;
import decorator.coffeestore.coffee.Espresso;
import decorator.coffeestore.condiment.Mocha;
import decorator.coffeestore.condiment.Whip;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecorateTest {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        log.info("{}:{}", beverage.getDescription(), beverage.cost());
        beverage = new Mocha(beverage);
        log.info("{}:{}", beverage.getDescription(), beverage.cost());
        beverage = new Whip(beverage);
        log.info("{}:{}", beverage.getDescription(), beverage.cost());
    }
}
