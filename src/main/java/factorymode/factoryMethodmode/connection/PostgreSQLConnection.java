package factorymode.factoryMethodmode.connection;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：PostgreSQLConnection
 * @Description：
 * @date: 2026年02月05日 13:18
 */
@Slf4j
public class PostgreSQLConnection implements IConnection {
    @Override
    public void connect() {
        log.info("PostgreSQL: 建立连接");
    }

    @Override
    public void disconnect() {
        log.info("PostgreSQL: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "PostgreSQL执行查询: " + sql;
    }
}
