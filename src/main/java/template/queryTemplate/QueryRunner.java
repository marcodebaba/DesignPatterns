package template.queryTemplate;

import java.sql.Connection;

/**
 * Created by marcopan on 17/9/26.
 */
public abstract class QueryRunner<T> {
    public abstract Connection createConnection();

    public abstract String createSQL();

    public abstract T runSQL(Connection conn, String sql);

    public T run() throws Exception {
        try (Connection conn = this.createConnection()) {
            String sql = this.createSQL();
            return runSQL(conn, sql);
        }
    }
}
