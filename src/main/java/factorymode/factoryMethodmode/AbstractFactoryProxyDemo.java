package factorymode.factoryMethodmode;

import factorymode.factoryMethodmode.command.ICommand;
import factorymode.factoryMethodmode.connection.IConnection;
import factorymode.factoryMethodmode.dbFactory.IDatabaseFactory;
import factorymode.factoryMethodmode.dbProvider.DatabaseFactoryProvider;

/**
 * @author：marco.pan
 * @ClassName：AbstractFactoryProxyDemo
 * @Description：
 * @date: 2026年02月05日 13:29
 */
public class AbstractFactoryProxyDemo {
    private static void testDatabase(String dbType) {
        System.out.println("测试 " + dbType + " 数据库");

        // 获取工厂
        IDatabaseFactory factory = DatabaseFactoryProvider.getFactory(dbType);

        // 创建连接对象
        IConnection connection = factory.createConnection();
        connection.connect();
        String queryResult = connection.executeQuery("SELECT * FROM users WHERE id = 1");
        System.out.println("查询结果: " + queryResult);
        connection.disconnect();

        // 创建命令对象
        ICommand command = factory.createCommand();
        command.execute("CREATE TABLE products (id INT, name VARCHAR(100))");
        System.out.println("命令结果: " + command.getResult());
    }

    public static void main(String[] args) {
        // 场景1: 使用MySQL
        testDatabase("MySQL");

        // 场景2: 使用PostgreSQL
        testDatabase("PostgreSQL");

        System.out.println("演示完成!");
    }
}
