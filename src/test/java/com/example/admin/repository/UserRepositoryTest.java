package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

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

    @Test
    public void read() {

        // read option 에서 id를 가져와 read 하겠다
        // Optional<T> findById(ID id) 반환 값이 Optional 이다 그래서 제네릭 타입으로 User 선언 하고 user 타입의 객체로 반환
        Optional<User> user = userRepository.findById(2L);

        // user에서 id = 2 값이 있다면 selectUser에 값을 대입해 selectUser을 출력하겠다
        user.ifPresent(selectUser ->{
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });


    }

    public void update() {


    }

    public void delete() {


    }
}
