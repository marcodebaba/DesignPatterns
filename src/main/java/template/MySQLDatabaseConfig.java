package template;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据库连接配置，绑定 spring.mysql.datasource.*
 */
@Data
@ConfigurationProperties(prefix = "spring.mysql.datasource")
public class MySQLDatabaseConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
