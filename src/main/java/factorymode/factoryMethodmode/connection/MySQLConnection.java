package factorymode.factoryMethodmode.connection;

/**
 * @author：marco.pan
 * @ClassName：MySQLConnection
 * @Description：
 * @date: 2026年02月05日 13:16
 */
public class MySQLConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("MySQL: 建立连接");
    }

    @Override
    public void disconnect() {
        System.out.println("MySQL: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "MySQL执行查询: " + sql;
    }
}

