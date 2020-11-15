package com.example.admin.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  OrderDetailStatus {

    REGISTERED(0, "등록", "주문 등록 상태"),
    UNREGISTERED(1, "해지", "주문 해지 상태"),
    WAITING(2, "검수", "주문 검수 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
