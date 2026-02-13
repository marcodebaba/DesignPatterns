package factorymode.factoryMethodmode.connection;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：OracleConnection
 * @Description：
 * @date: 2026年02月09日 15:43
 */
@Slf4j
public class OracleConnection  implements IConnection {
    @Override
    public void connect() {
        log.info("Oracle: 建立连接");
    }

    @Override
    public void disconnect() {
        log.info("Oracle: 断开连接");
    }

    @Override
    public String executeQuery(String sql) {
        return "Oracle执行查询: " + sql;
    }
}
