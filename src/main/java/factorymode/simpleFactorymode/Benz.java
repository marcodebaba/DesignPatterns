package factorymode.simpleFactorymode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Benz implements AbstractCar {

    public void createCar() {
        log.info("create Benz");
    }

}
