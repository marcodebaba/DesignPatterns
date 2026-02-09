package factorymode.factoryMethodmode.dbFactory;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.connection.MySQLConnection;
import factorymode.factoryMethodmode.command.MySQLCommand;

/**
 * @author：marco.pan
 * @ClassName：MySQLFactory
 * @Description：MySQLFactory，用MySQL实现方式来实现产品等级
 * @date: 2026年02月05日 13:20
 */
public class MySQLFactory implements IAbstractDatabaseFactory {
    @Override
    public IConnection createConnection() {
        return new MySQLConnection();
    }

    @Override
    public ICommand createCommand() {
        return new MySQLCommand();
    }
}