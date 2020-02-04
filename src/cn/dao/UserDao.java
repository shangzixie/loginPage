package cn.dao;

import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {


    //common use JDBC template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * login method
     * @param loginUser only contains username and password
     * @return contains all user's information; if not exists return null;
     */


    public User login(User loginUser){
        try {
            //sql
            String sql = "select * from user where username = ? and password = ?";
            // invoking  query method
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
