package factorymode.factoryMethodmode.connection;

/**
 * @author：marco.pan
 * @ClassName：PostgreSQLConnection
 * @Description：
 * @date: 2026年02月05日 13:18
 */
public class PostgreSQLConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("PostgreSQL: 建立连接");
    }

    @Override
    public void disconnect() {
        System.out.println("PostgreSQL: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "PostgreSQL执行查询: " + sql;
    }
}