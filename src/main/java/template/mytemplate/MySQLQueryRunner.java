package template.mytemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by marcopan on 17/9/26.
 */
@Slf4j
public class MySQLQueryRunner extends QueryRunner<List<String>> {

    private static final String DRIVER_CLASS_KEY = "spring.datasource.driver-class-name";
    private static final String URL_KEY = "spring.datasource.url";
    private static final String USERNAME_KEY = "spring.datasource.username";
    private static final String PASSWORD_KEY = "spring.datasource.password";
    private static final Properties YAML_PROPERTIES = loadYamlProperties();

    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public MySQLQueryRunner() {
        this(
                YAML_PROPERTIES.getProperty(DRIVER_CLASS_KEY),
                YAML_PROPERTIES.getProperty(URL_KEY),
                YAML_PROPERTIES.getProperty(USERNAME_KEY),
                YAML_PROPERTIES.getProperty(PASSWORD_KEY)
        );
    }

    public MySQLQueryRunner(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private static Properties loadYamlProperties() {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application.yml"));
        Properties properties = factoryBean.getObject();
        return properties != null ? properties : new Properties();
    }

    @Override
    public Connection createConnection() {
        try {
            if (driverClassName == null || url == null || username == null || password == null) {
                throw new IllegalStateException(
                        "Missing datasource config. Set spring.datasource.* in application.yml."
                );
            }
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Create MySQL connection failed: " + url, e);
        }
    }

    @Override
    public String createSQL() {
        return "select name from user where id = 1";
    }

    @Override
    public List<String> runSQL(Connection conn, String sql) {
        log.info("runSQL from MySQLQueryRunner, sql={}", sql);
        List<String> usernames = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setQueryTimeout(5);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    usernames.add(rs.getString(1));
                }
                return usernames;
            }
        } catch (SQLException e) {
            throw new RuntimeException("runSQL failed", e);
        }
    }
}
