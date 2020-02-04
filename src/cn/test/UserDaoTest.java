package cn.test;

import cn.dao.UserDao;
import cn.domain.User;
import org.junit.jupiter.api.Test;
import javax.sql.DataSource;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("manager");
        loginuser.setPassword("1234567WDpyznl");
        UserDao dao = new UserDao();
        dao.login(loginuser);

        System.out.println((loginuser));
    }
}
