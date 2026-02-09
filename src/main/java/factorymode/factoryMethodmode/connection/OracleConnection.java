package factorymode.factoryMethodmode.connection;

/**
 * @author：marco.pan
 * @ClassName：OracleConnection
 * @Description：
 * @date: 2026年02月09日 15:43
 */
public class OracleConnection  implements IConnection {
    @Override
    public void connect() {
        System.out.println("Oracle: 建立连接");
    }

    @Override
    public void disconnect() {
        System.out.println("Oracle: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "Oracle执行查询: " + sql;
    }
}
