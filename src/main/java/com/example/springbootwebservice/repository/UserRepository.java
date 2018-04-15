package com.example.springbootwebservice.repository;


import com.example.springbootwebservice.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {


    private Map<Long, User> cachedUsers = new HashMap<>();

    @PostConstruct
    public void init() {


        User user = createUser(1, "张三", 22);

        User user2 = createUser(2, "李四", 22);

        User user3 = createUser(3, "王五", 22);

        cachedUsers.put(1L, user);
        cachedUsers.put(2L, user2);
        cachedUsers.put(3L, user3);


    }

    public User findById(long id) {

        return cachedUsers.get(id);
    }


    private User createUser(long id, String name, Integer age) {


        User user = new User();

        user.setId(id);

        user.setName(name);

        user.setAge(age);

        return user;


    }


}




































































