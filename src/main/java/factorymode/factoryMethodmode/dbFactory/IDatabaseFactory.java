package factorymode.factoryMethodmode.dbFactory;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;

/**
 * @author：marco.pan
 * @ClassName：IDatabaseFactory
 * @Description：
 * @date: 2026年02月06日 13:17
 */
public interface IDatabaseFactory {
    IConnection createConnection();

    ICommand createCommand();
}
