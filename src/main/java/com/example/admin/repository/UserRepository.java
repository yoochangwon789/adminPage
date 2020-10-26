package com.example.admin.repository;

import com.example.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User id type = Long 이기 때문에 제네릭에 Long 작성
}
