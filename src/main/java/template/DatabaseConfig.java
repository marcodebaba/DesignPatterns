package template;

/**
 * 数据库连接配置
 */
public class DatabaseConfig {
    private final String driverClass;
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConfig(String driverClass, String url, String username, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
