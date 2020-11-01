package com.example.admin.repository;

import com.example.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    // User id type = Long 이기 때문에 제네릭에 Long 작성
//
//    // select * from user where account = ? << test03, test04
//    Optional<User> findByAccount(String account);
//
//    // select * from user where email = ? << test03@gmail.com
//    Optional<User> findByEmail(String email);
//
//    // select * from user where account = ? and email = ?
//    Optional<User> findByAccountAndEmail(String account, String email);
}
