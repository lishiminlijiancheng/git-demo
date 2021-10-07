package users;

import jdbc_tool.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginUser)
    {
        try {
            String name=loginUser.getName();
            String password=loginUser.getPassword();
            String sql="select * from users where name=? and password=?";
        User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class)
        ,loginUser.getName(),loginUser.getPassword());
        return user;}
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
