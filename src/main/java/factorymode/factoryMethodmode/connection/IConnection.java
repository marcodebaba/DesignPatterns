package factorymode.factoryMethodmode.connection;

/**
 * @author：marco.pan
 * @ClassName：Connection
 * @Description：
 * @date: 2026年02月05日 11:12
 */
public interface IConnection {
    void connect();

    void disconnect();

    String executeQuery(String sql);
}
