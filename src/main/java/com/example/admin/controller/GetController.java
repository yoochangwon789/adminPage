package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")     // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod!!!";
    }

    // getMethod를 통해서 파라미터를 요청하면 출력해주는 방법
    @GetMapping("/getParameter")    // localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {

        // 지역내 변수에서 password 사용할 수 있다 하지만 Spring에서 추천하는 방법은 RequestParam에서 local변수를 사용하지 않는 것
        // 하지만 어쩔 수 없이 local변수를 사용해야 한다면
        // @RequestParam(name = "password") String pwd 에서 파람에서 요청한 패스워드가 변수랑 같지 않아서 맵핑이 안되므로 같이
        // name를 통해 password를 맞춰 줘야함(chrome 에서 password로 요청하면 똑같이 값이 나올것 이다)
        String password = "bbbb";

        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + pwd;
    }

    // localhost8080:/api/multParameter?account=abcd&email=study@gamil.com&page=10
    // 여러가지 param을 받는 방법의 get방식 객체를 통하여 model package/SearchParam을 통해 여러가지 파람을 받을 것이다
//    @GetMapping("/getMultiParameter")
//    public String getMultiParameter(SearchParam searchParam) {
//
//        System.out.println(searchParam.getAccount());
//        System.out.println(searchParam.getEmail());
//        System.out.println(searchParam.getPage());
//
//        // { "account : "", "email" : "", "page" : 0 } json형태로 데이터 통신을 하기를 원함
//        return "OK";
//    }

    // json 형태로 데이터를 받는 방법 받은 객체 내용을 그대로 return 시켜준다 그러면 json 형태로 Spring에서 바꿔주기 때문에 사용이 바로 가능하다
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account : "", "email" : "", "page" : 0 } json형태로 데이터 통신을 하기를 원함
        return searchParam;
    }
}
