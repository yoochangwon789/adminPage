package com.example.admin.controller.api;

import com.example.admin.controller.CrudController;
import com.example.admin.model.entity.User;
import com.example.admin.model.network.request.UserApiRequest;
import com.example.admin.model.network.response.UserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // java 에서 쓰는 loge System 데이터가 어떻게 움직이는지 콘솔창에 흔적을 보기 위해 쓰는 기능 sout 대신 사용 test가 아닌 실제 프로젝트에서는 이것을 많이 사용함
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
}
