package edu.nefu.softwarewebsite.dao;

import edu.nefu.softwarewebsite.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

    User findOneById(String id);

    User findOneByName(String name);
}
