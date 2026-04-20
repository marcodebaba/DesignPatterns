package template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// JDBC
public abstract class JdbcTemplate {

    private final DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    private void bindParameters(PreparedStatement pstmt, Object[] values) throws Exception {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
        }
    }


    private <T> List<T> parseResultSet(ResultSet rs, RowMapper<T> rowMapper) throws Exception {
        List<T> result = new ArrayList<T>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    public <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object[] values) {
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = this.createPreparedStatement(conn, sql)) {
            //1、获取连接
            //2、创建语句集
            this.bindParameters(pstmt, values);
            //3、执行语句集，并且获得结果集
            try (ResultSet rs = pstmt.executeQuery()) {
                //4、解析语句集
                return this.parseResultSet(rs, rowMapper);
            }
        } catch (Exception e) {
            throw new RuntimeException("executeQuery failed", e);
        }
    }
}
