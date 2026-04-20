package template.dao;

import template.JdbcTemplate;
import template.entity.Member;

import javax.sql.DataSource;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> selectAll() {
        String sql = "select * from t_member";
        return super.executeQuery(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));
            return member;
        }, new Object[0]);
    }
}
