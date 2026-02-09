package factorymode.factoryMethodmode.dbProvider;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.dbFactory.IDatabaseFactory;
import factorymode.factoryMethodmode.handler.LoggingInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author：marco.pan
 * @ClassName：ProxyDatabaseFactory
 * @Description：
 * @date: 2026年02月05日 13:25
 */
public class ProxyDatabaseFactory implements IDatabaseFactory {
    private final IDatabaseFactory factory;
    private final String dbType;

    public ProxyDatabaseFactory(IDatabaseFactory factory, String dbType) {
        this.factory = factory;
        this.dbType = dbType;
    }

    @Override
    public IConnection createConnection() {
        IConnection connection = factory.createConnection();
        // 返回包装后的代理对象，在代理类中做功能增强
        return (IConnection) Proxy.newProxyInstance(
                connection.getClass().getClassLoader(),
                new Class[]{IConnection.class},
                new LoggingInvocationHandler(connection, dbType + "-Connection")
        );
    }

    @Override
    public ICommand createCommand() {
        ICommand command = factory.createCommand();
        return (ICommand) Proxy.newProxyInstance(
                command.getClass().getClassLoader(),
                new Class[]{ICommand.class},
                new LoggingInvocationHandler(command, dbType + "-Command")
        );
    }
}