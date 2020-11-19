package com.example.admin.controller.api;

import com.example.admin.controller.CrudController;
import com.example.admin.model.network.request.PartnerApiRequest;
import com.example.admin.model.network.response.PartnerApiResponse;
import com.example.admin.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = partnerApiLogicService;
    }
}
