package com.example.admin.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor // 변수 없느 생성자 기능 lombok
@Entity // == table 클래스 이름과 데이터베이스 이름이 같으면 Table 어노텐션을 사용안해도 맵핑이 JPA에서 저절로 이루어짐
@ToString(exclude = {"orderGroupList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
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

    @CreatedDate
    // 따로 이제 created, updated 객체를 생성하여 설정값을 넣어주지 않더라도 알아서 jpa가 넣어준다 데이터 베이스 에서 확인 해보기
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy // by로 끝나는 것들은 getCurrentAuditor 에서의 값을 반환받는다
    private String updatedBy;

    // User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}