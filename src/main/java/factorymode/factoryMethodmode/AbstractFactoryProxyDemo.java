package factorymode.factoryMethodmode;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.dbFactory.IAbstractDatabaseFactory;
import factorymode.factoryMethodmode.dbProvider.DatabaseFactoryProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：marco.pan
 * @ClassName：AbstractFactoryProxyDemo
 * @Description：Database Client Test
 * @date: 2026年02月05日 13:29
 */
@Slf4j
public class AbstractFactoryProxyDemo {
    private static void testDatabase(String dbType) {
        log.info("测试 {} 数据库", dbType);

        // 获取工厂
        IAbstractDatabaseFactory factory = DatabaseFactoryProvider.getFactory(dbType);

        // 创建连接对象
        IConnection connection = factory.createConnection();
        connection.connect();
        String queryResult = connection.executeQuery("SELECT * FROM users WHERE id = 1");
        log.info("查询结果: {}", queryResult);
        connection.disconnect();

        // 创建命令对象
        ICommand command = factory.createCommand();
        command.execute("CREATE TABLE products (id INT, name VARCHAR(100))");
        log.info("命令结果: {}", command.getResult());
    }

    public static void main(String[] args) {
        // 场景1: 使用MySQL
        testDatabase("MySQL");
        log.info("MySQL演示完成!");

        // 场景2: 使用PostgreSQL
        testDatabase("PostgreSQL");
        log.info("PostgreSQL演示完成!");

        // 场景3: Oracle
        testDatabase("Oracle");
        log.info("Oracle演示完成!");
    }
}
