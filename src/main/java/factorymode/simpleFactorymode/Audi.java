package factorymode.simpleFactorymode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Audi implements AbstractCar {

    public void createCar() {
        log.info("create Audi");
    }

}
