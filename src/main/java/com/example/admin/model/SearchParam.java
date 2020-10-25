package com.example.admin.model;

// lombok 적용, 생성자, getter and setter 적용시키기
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {

    private String account;

    private String email;

    private int page;

    // { "account : "", "email" : "", "page" : 0 }
}
