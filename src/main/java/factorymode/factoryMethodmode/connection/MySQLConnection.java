package factorymode.factoryMethodmode.connection;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：MySQLConnection
 * @Description：
 * @date: 2026年02月05日 13:16
 */
@Slf4j
public class MySQLConnection implements IConnection {
    @Override
    public void connect() {
        log.info("MySQL: 建立连接");
    }

    @Override
    public void disconnect() {
        log.info("MySQL: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "MySQL执行查询: " + sql;
    }
}
