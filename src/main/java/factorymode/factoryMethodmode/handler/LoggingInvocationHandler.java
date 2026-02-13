package factorymode.factoryMethodmode.handler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author：marco.pan
 * @ClassName：LoggingInvocationHandler
 * @Description：处理代理方法日志打印
 * @date: 2026年02月05日 13:25
 */
@Slf4j
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
        log.info("\n[代理-{}] 方法调用开始: {}", proxyName, method.getName());
        if (args != null && args.length > 0) {
            log.info("[代理-{}] 参数: {}", proxyName, method.getName());
        }

        Object result = null;
        try {
            // 调用实际方法
            result = method.invoke(target, args);

            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;

            log.info("[代理-{}] 方法调用成功", proxyName);
            log.info("[代理-{}] 执行时间: {} ms", proxyName, String.format("%.3f", executionTime));

            if (result != null) {
                log.info("[代理-{}] 返回值: {}", proxyName, result);
            }

        } catch (Exception e) {
            log.error("[代理-{}] 方法调用失败: {}", proxyName, e.getMessage());
            throw e;
        }

        return result;
    }
}