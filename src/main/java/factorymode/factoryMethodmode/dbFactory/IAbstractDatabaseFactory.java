package factorymode.factoryMethodmode.dbFactory;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;

/**
 * @author：marco.pan
 * @ClassName：IAbstractDatabaseFactory
 * @Description：定义所有的产品等级
 * @date: 2026年02月06日 13:17
 */
public interface IAbstractDatabaseFactory {

    IConnection createConnection();

    ICommand createCommand();
}
