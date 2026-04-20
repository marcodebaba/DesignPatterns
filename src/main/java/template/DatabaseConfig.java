package template;

/**
 * 数据库连接配置
 */
public class DatabaseConfig {
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConfig(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
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
