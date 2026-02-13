package proxy.cglibProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by marcopan on 2018/9/8.
 */
@Slf4j
public class RealSubject implements ISubject {
    public void requestHouse1() {
        log.info("requestHouse1 from RealSubject");
    }

    public void requestHouse2() {
        log.info("requestHouse2 from RealSubject");
    }
}
