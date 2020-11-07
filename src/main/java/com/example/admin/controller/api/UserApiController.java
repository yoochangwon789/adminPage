package com.example.admin.controller.api;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.network.Header;
import com.example.admin.model.network.request.UserApiRequest;
import com.example.admin.model.network.response.UserApiResponse;
import com.example.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j  // java 에서 쓰는 loge System 데이터가 어떻게 움직이는지 콘솔창에 흔적을 보기 위해 쓰는 기능 sout 대신 사용 test가 아닌 실제 프로젝트에서는 이것을 많이 사용함
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")    // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
