package proxy.cglibProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
//        String filePath = ISubject.class.getResource("").getPath();
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, filePath);

        ISubject cglibProxy = (ISubject) new CglibProxySubject().getCglibProxy(new RealSubject().getClass());
        log.info("{}", cglibProxy);
        cglibProxy.requestHouse1();
        cglibProxy.requestHouse2();
    }
}
