package proxy.cglibProxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxySubject {

    public Object getCglibProxy(Class<?> target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        // o是代理对象，target是被代理对象
        enhancer.setCallbacks(new Callback[]{(MethodInterceptor) (o, method, objects, methodProxy) -> {
            // before
            Object result = method.invoke(target.newInstance(), objects);
            //Object result = methodProxy.invokeSuper(o, objects);
            // after
            return result;
        }});
        return enhancer.create();
    }
}
