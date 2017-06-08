package com.innovae.repository;

import com.innovae.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Polotin on 2017/5/19.
 */
@Repository
public interface AccountRepository extends JpaRepository<User,String> {
//    @Query("select u from User u where id=?1 and password=?2")
//    List<User> validAccountWhenLogin(String id, String password);

//    @Query("insert into User(id,name,password) values (?1,?2,?3)")
//    List<User> register(String id, String name, String password);
}
