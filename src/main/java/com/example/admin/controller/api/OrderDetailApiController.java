package com.example.admin.controller.api;

import com.example.admin.controller.CrudController;
import com.example.admin.model.network.request.OrderDetailApiRequest;
import com.example.admin.model.network.response.OrderDetailApiResponse;
import com.example.admin.service.OrderDetailApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailApiLogicService orderDetailApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = orderDetailApiLogicService;
    }
}
