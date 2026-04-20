package proxy.mybatisSample;

import java.lang.reflect.Proxy;

public class MybatisFactory {
    public static Object getInstance(Class clazz) {
        generateSourceCode(clazz);
        // Proxy这个类的作用就是用来动态创建一个代理对象的类
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MybatisHandler());
    }

    public static void generateSourceCode(Class clazz) {
        // 兼容不同JDK版本，开启JDK动态代理类落盘
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }
}
