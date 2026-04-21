package template.queryTemplate;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MySQLQueryRunner extends QueryRunner<List<String>> {

    private final DataSource dataSource;
    private final String sql;

    public MySQLQueryRunner(DataSource dataSource, String sql) {
        this.dataSource = dataSource;
        this.sql = sql;
    }

    @Override
    public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public String createSQL() {
        return sql;
    }

    @Override
    public List<String> runSQL(Connection conn, String sql) throws SQLException {
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
        }
    }
}
