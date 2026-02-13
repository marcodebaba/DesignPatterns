package proxy.proxyFactory;

import lombok.extern.slf4j.Slf4j;
import proxy.staticProxy.IAbstractSubject;

/**
 * 真实角色--房东
 *
 * @author marcopan
 */
@Slf4j
public class RealSubject implements IAbstractSubject {

    public void rentHouse() {
        log.info("rentHouse from RealSubject");
    }
}
