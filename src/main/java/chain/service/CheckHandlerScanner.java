package chain.service;

import chain.handler.CheckHandler;
import chain.handler.OrderCheckHandler;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class CheckHandlerScanner {

    private CheckHandlerScanner() {
    }

    public static List<OrderCheckHandler> scan(String basePackage) {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CheckHandler.class));

        Set<BeanDefinition> candidates = scanner.findCandidateComponents(basePackage);
        List<OrderCheckHandler> handlers = new ArrayList<OrderCheckHandler>();
        for (BeanDefinition candidate : candidates) {
            handlers.add(instantiate(candidate.getBeanClassName()));
        }
        return handlers;
    }

    private static OrderCheckHandler instantiate(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (!OrderCheckHandler.class.isAssignableFrom(clazz)) {
                throw new IllegalStateException(className + " 标注了@CheckHandler但未实现OrderCheckHandler");
            }
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return (OrderCheckHandler) constructor.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("无法实例化CheckHandler: " + className, e);
        }
    }
}
