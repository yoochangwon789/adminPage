package com.example.admin.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    // 1 : N

    // LAZY = 지연로딩 , EAGER = 즉시로딩

    // LAZY = SELECT * FROM item where id = ? 즉, 우리가 선택한 item의 대해서만 찾아온다

    // EAGER = 연관관계가 설정되어있는 모든 테이블에 대해서 join이 일어난다 그래서 OnoToOne 이라던지 한건만 존재 할 때 추천하는 방식
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}
