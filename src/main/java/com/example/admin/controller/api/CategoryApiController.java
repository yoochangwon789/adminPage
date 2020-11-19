package com.example.admin.controller.api;

import com.example.admin.controller.CrudController;
import com.example.admin.model.network.request.CategoryApiRequest;
import com.example.admin.model.network.response.CategoryApiResponse;
import com.example.admin.service.CategoryApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryApiLogicService categoryApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = categoryApiLogicService;
    }
}
