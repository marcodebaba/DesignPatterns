package proxy.mybatisSample;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MybatisHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) {
        log.info("connect DB");
        Select annotation = method.getAnnotation(Select.class);
        log.info("{}", annotation.value()[0]);
        return null;
    }
}
