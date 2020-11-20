package com.example.admin.controller.api;

import com.example.admin.controller.CrudController;
import com.example.admin.model.entity.Item;
import com.example.admin.model.network.request.ItemApiRequest;
import com.example.admin.model.network.response.ItemApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

    //@Autowired
    //private ItemApiLogicService itemApiLogicService;

    // CrudController 에 있는 baseService 의 객체를 채워 줘야 한다 왜냐하면 baseService 에 내가 원하는 테이블의 객체를 넣어 줘야 지
    // CrudController 가 작동해서 내가 원하는 mapping 의 값을 얻을 수 있다.
    //@PostConstruct  // 초기 생성자 메서드 같은 의미
    //public void init() {
        //this.baseService = itemApiLogicService;
    //}
}
