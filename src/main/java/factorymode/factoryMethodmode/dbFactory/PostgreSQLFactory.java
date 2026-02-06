package factorymode.factoryMethodmode.dbFactory;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.command.PostgreSQLCommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.connection.PostgreSQLConnection;

/**
 * @author：marco.pan
 * @ClassName：PostgreSQLFactory
 * @Description：
 * @date: 2026年02月05日 13:23
 */
public class PostgreSQLFactory implements IDatabaseFactory {
    @Override
    public IConnection createConnection() {
        return new PostgreSQLConnection();
    }

    @Override
    public ICommand createCommand() {
        return new PostgreSQLCommand();
    }
}