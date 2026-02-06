package factorymode.factoryMethodmode.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author：marco.pan
 * @ClassName：LoggingInvocationHandler
 * @Description：
 * @date: 2026年02月05日 13:25
 */
public class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;
    private final String proxyName;

    public LoggingInvocationHandler(Object target, String proxyName) {
        this.target = target;
        this.proxyName = proxyName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();

        System.out.println("\n[代理-" + proxyName + "] 方法调用开始: " + method.getName());
        if (args != null && args.length > 0) {
            System.out.println("[代理-" + proxyName + "] 参数: " + java.util.Arrays.toString(args));
        }

        Object result = null;
        try {
            // 调用实际方法
            result = method.invoke(target, args);

            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;

            System.out.println("[代理-" + proxyName + "] 方法调用成功");
            System.out.println("[代理-" + proxyName + "] 执行时间: " +
                    String.format("%.3f", executionTime) + " ms");

            if (result != null) {
                System.out.println("[代理-" + proxyName + "] 返回值: " + result);
            }

        } catch (Exception e) {
            System.err.println("[代理-" + proxyName + "] 方法调用失败: " + e.getMessage());
            throw e;
        }

        return result;
    }
}