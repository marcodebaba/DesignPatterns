package template.mytemplate;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by marcopan on 17/9/26.
 */
@Slf4j
public class OracleQueryRunner extends QueryRunner {

    @Override
    public Connection createConnection() {
        log.info("createConnection from OracleQueryRunner");
        return null;
    }

    @Override
    public String createSQL() {
        return "createSQL from OracleQueryRunner";
    }

    @Override
    public ResultSet runSQL(Connection conn, String sql) {
        log.info("runSQL from OracleQueryRunner");
        Statement st = null;
        try {
            st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
