package proxy.proxyFactory;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import proxy.staticProxy.IAbstractSubject;

import java.lang.reflect.Method;

/**
 * @author：marco.pan
 * @ClassName：ProxyFactoryDemo
 * @Description：
 * @date: 2021年10月09日 10:19 上午
 */
public class ProxyFactoryDemo {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new RealSubject());
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
//                return new StaticMethodMatcherPointcut() {
//                    @Override
//                    public boolean matches(Method method, Class<?> targetClass) {
//                        return "rentHouse".equals(method.getName());
//                    }
//                };
                return new Pointcut() {
                    @Override
                    public ClassFilter getClassFilter() {
                        return new ClassFilter() {
                            @Override
                            public boolean matches(Class<?> clazz) {
                                return clazz.equals(RealSubject.class);
                            }
                        };
                    }

                    @Override
                    public MethodMatcher getMethodMatcher() {
                        return new MethodMatcher() {
                            @Override
                            public boolean matches(Method method, Class<?> targetClass) {
                                return method.getName().equals("rentHouse");
                            }

                            @Override
                            public boolean isRuntime() {
                                return false;
                            }

                            @Override
                            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                                return false;
                            }
                        };
                    }
                };
            }

            @Override
            public Advice getAdvice() {
                return new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation invocation) throws Throwable {
                        System.out.println("before...");
                        Object result = invocation.proceed();
                        System.out.println("after...");
                        return result;
                    }
                };
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });

        IAbstractSubject realSubject = (IAbstractSubject) proxyFactory.getProxy();
        realSubject.rentHouse();
    }
}
