package template.queryTemplate;

import lombok.extern.slf4j.Slf4j;
import template.MySQLDatabaseConfig;

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

    private final String driverClass;
    private final String url;
    private final String username;
    private final String password;

    public MySQLQueryRunner(MySQLDatabaseConfig databaseConfig) {
        this(
                databaseConfig.getDriverClassName(),
                databaseConfig.getUrl(),
                databaseConfig.getUsername(),
                databaseConfig.getPassword()
        );
    }

    public MySQLQueryRunner(String driverClass, String url, String username, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection createConnection() {
        try {
            if (driverClass == null || url == null || username == null || password == null) {
                throw new IllegalStateException(
                        "Missing datasource config. Set spring.datasource.* in application.yml."
                );
            }
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Create MySQL connection failed: " + url, e);
        }
    }

    @Override
    public String createSQL() {
        return "select name from user";
    }

    @Override
    public List<String> runSQL(Connection conn, String sql) {
        log.info("runSQL from MySQLQueryRunner, sql={}", sql);
        List<String> usernames = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setQueryTimeout(5);
            try (ResultSet rs = stmt.executeQuery()) {
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
