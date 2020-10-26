package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends AdminApplicationTests {

    // Repository CRUD test
    @Autowired  // new 객체를 만들어서 할 필요없이 객체를 사용할 수 있다 Dependency Injection (DI) Spring에서 직접 객체를 관리한다
    private UserRepository userRepository;

    @Test
    public void create() {

        User user = new User();

        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser03");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    public void read() {


    }

    public void update() {


    }

    public void delete() {


    }
}
