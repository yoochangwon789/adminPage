package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends AdminApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {

        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime unregisteredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();

        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setUnregisteredAt(unregisteredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        Assertions.assertNotNull(newPartner);
        Assertions.assertEquals(newPartner.getName(), name);

    }

    @Test
    public void read() {

        String name = "Partner01";

        Optional<Partner> partner = partnerRepository.findById(1L);

        partner.ifPresent(selectPartner -> {

            Assertions.assertEquals(selectPartner.getName(), name);

            System.out.println(selectPartner.getAddress());
            System.out.println(selectPartner.getBusinessNumber());
        });
    }
}
