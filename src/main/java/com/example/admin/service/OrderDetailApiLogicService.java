package com.example.admin.service;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.entity.OrderDetail;
import com.example.admin.model.network.Header;
import com.example.admin.model.network.request.OrderDetailApiRequest;
import com.example.admin.model.network.request.OrderGroupApiRequest;
import com.example.admin.model.network.response.OrderDetailApiResponse;
import com.example.admin.repository.ItemRepository;
import com.example.admin.repository.OrderDetailRepository;
import com.example.admin.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderDetailApiLogicService implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {

        OrderDetailApiRequest body = request.getData();

        OrderDetail orderDetail = OrderDetail.builder()
                .status(body.getStatus())
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .quantity(body.getQuantity())
                .totalPrice(body.getTotalPrice())
                .item(itemRepository.getOne(body.getItemId()))
                .orderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                .build();

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<OrderDetailApiResponse> response(OrderDetail orderDetail) {
        return null;
    }
}
