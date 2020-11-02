package com.example.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor // 변수 없느 생성자 기능 lombok
@Entity // == table 클래스 이름과 데이터베이스 이름이 같으면 Table 어노텐션을 사용안해도 맵핑이 JPA에서 저절로 이루어짐
@ToString(exclude = {"orderGroupList"})
public class User {

    @Id
    // GeneratedValue라는 전략옵션을 가져가고 IDENTITY라는 것을 사용한다 MYSQL 때문
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}