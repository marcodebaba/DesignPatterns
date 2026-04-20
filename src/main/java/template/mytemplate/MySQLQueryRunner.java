package template.mytemplate;

import lombok.extern.slf4j.Slf4j;
import template.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcopan on 17/9/26.
 */
@Slf4j
public class MySQLQueryRunner extends QueryRunner<List<String>> {

    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public MySQLQueryRunner(DatabaseConfig databaseConfig) {
        this(
                databaseConfig.getDriverClassName(),
                databaseConfig.getUrl(),
                databaseConfig.getUsername(),
                databaseConfig.getPassword()
        );
    }

    public MySQLQueryRunner(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
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
