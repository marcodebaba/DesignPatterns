package factorymode.factoryMethodmode.dbProvider;

import factorymode.factoryMethodmode.dbFactory.IDatabaseFactory;
import factorymode.factoryMethodmode.dbFactory.MySQLFactory;
import factorymode.factoryMethodmode.dbFactory.PostgreSQLFactory;
import factorymode.factoryMethodmode.dbFactory.ProxyDatabaseFactory;


/**
 * @author：marco.pan
 * @ClassName：DatabaseFactoryProvider
 * @Description：
 * @date: 2026年02月05日 13:28
 */
public class DatabaseFactoryProvider {
    public static IDatabaseFactory getFactory(String dbType) {
        IDatabaseFactory factory;

        switch (dbType.toLowerCase()) {
            case "mysql":
                factory = new MySQLFactory();
                break;
            case "postgresql":
                factory = new PostgreSQLFactory();
                break;
            default:
                throw new IllegalArgumentException("不支持的数据库类型: " + dbType);
        }

        return new ProxyDatabaseFactory(factory, dbType);
    }
}
