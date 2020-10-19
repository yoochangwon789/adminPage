package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // 클래스에서 RequestMapping 시킨것은 두가지 주소가 겹치더라도 상관없다 하지만 Method에서는 주소가 겹치면 안된다.
public class PostController {

    // HTML <Form>
    // ajax 검색
    // http post body -> data  // Body에다가 data를 집어 넣어서 보내는 것이 post

    // @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {

        return searchParam;
    }
    
}
