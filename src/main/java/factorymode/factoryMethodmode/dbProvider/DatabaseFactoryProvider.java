package factorymode.factoryMethodmode.dbProvider;

import factorymode.factoryMethodmode.dbFactory.*;

/**
 * @author：marco.pan
 * @ClassName：DatabaseFactoryProvider
 * @Description：注册所有的产品族，返回产品族的代理类
 * @date: 2026年02月05日 13:28
 */
public class DatabaseFactoryProvider {
    public static IAbstractDatabaseFactory getFactory(String dbType) {
        IAbstractDatabaseFactory factory;

        switch (dbType.toLowerCase()) {
            case "mysql":
                factory = new MySQLFactory();
                break;
            case "postgresql":
                factory = new PostgreSQLFactory();
                break;
            case "oracle":
                factory = new OracleFactory();
                break;
            default:
                throw new IllegalArgumentException("不支持的数据库类型: " + dbType);
        }

        return new ProxyDatabaseFactory(factory, dbType);
    }
}
