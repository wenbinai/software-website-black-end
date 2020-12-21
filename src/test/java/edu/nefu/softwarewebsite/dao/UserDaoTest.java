package edu.nefu.softwarewebsite.dao;

import edu.nefu.softwarewebsite.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test_userDao() {
        User user = userDao.findOneById("1");
        System.out.println(user);
    }
}
