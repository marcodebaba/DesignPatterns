package template.queryTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class QueryRunner<T> {

    public abstract Connection createConnection() throws SQLException;

    public abstract String createSQL();

    public abstract T runSQL(Connection conn, String sql) throws SQLException;

    public T execute() throws SQLException {
        try (Connection conn = this.createConnection()) {
            String sql = this.createSQL();
            return runSQL(conn, sql);
        }
    }
}
