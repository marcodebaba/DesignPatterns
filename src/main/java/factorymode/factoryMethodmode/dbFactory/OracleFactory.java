package factorymode.factoryMethodmode.dbFactory;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.command.OracleCommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.connection.OracleConnection;

/**
 * @author：marco.pan
 * @ClassName：OracleFactory
 * @Description：
 * @date: 2026年02月09日 15:45
 */
public class OracleFactory  implements IAbstractDatabaseFactory {
    @Override
    public IConnection createConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand createCommand() {
        return new OracleCommand();
    }
}