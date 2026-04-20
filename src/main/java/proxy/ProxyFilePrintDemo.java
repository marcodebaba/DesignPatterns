package proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理和CGLIB代理
 *
 * @ author marco.pan
 * @ version 1.0
 * @ date 2026年04月08日 0:43
 */
@Slf4j
public class ProxyFilePrintDemo {

    public static void main(String[] args) {
        proxyByJDK();
//        proxyByCGLIB();
    }

//    private static void proxyByCGLIB() {
//        // "./"代表设置到当前项目目录下，可以自行设置指定路径输出
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Calculator.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                log.info("CGLIB代理增强逻辑...");
//                return methodProxy.invokeSuper(o, objects);
//            }
//        });
//        Calculator calculator = (Calculator) enhancer.create();
//        System.out.println(calculator.add(1, 2));
//    }

    private static void proxyByJDK() {
        // JDK 动态代理调试开关，当使用 java.lang.reflect.Proxy 生成代理类时，把 JVM 运行时生成的 .class 文件保存到磁盘
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Calculator target = new Calculator();
        ICalculator proxy = (ICalculator) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{ICalculator.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.nanoTime();
                        Object result = method.invoke(target, args);
                        System.out.println("方法 " + method.getName() + " 耗时: " + (System.nanoTime() - start) + "ns");
                        return result;
                    }
                });
        System.out.println(proxy.add(1, 2));
        System.out.println(proxy.subtract(1, 2));
    }
}

interface ICalculator {
    int add(int a, int b);

    int subtract(int a, int b);
}

class Calculator implements ICalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
