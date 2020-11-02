package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends AdminApplicationTests {

    // Repository CRUD test
    @Autowired  // new 객체를 만들어서 할 필요없이 객체를 사용할 수 있다 Dependency Injection (DI) Spring에서 직접 객체를 관리한다
    private UserRepository userRepository;

    @Test
    public void create() {

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);

    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("----------------------주문묶음----------------------");
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("수령지 : " +orderGroup.getRevAddress());
            System.out.println("수령인 : " +orderGroup.getRevName());
            System.out.println("총수량 : " +orderGroup.getTotalQuantity());

            System.out.println("----------------------주문상세----------------------");

            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());

            });
        });

        Assertions.assertNotNull(user);
    }

    @Test
    public void update() {

        Optional<User> user = userRepository.findById(2L);

        // 삭제 하려면 2번 데이터가 반드시 존재해야 하기 때문에 Assert라는

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setCreatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    // 만약 데이터를 계속 지우게 되면 Test 코드에서 데이터가 다 날아가기 때문에 Transactional 사용하여 데이터 삭제를 방지한다
    // comfile을 하게 되면 당연히 실행되고 데이터 베이스에 데이터는 삭제되지 않는다 Rolled back transaction 다시 돌려줌
    // 쉽게 말하면 Transactional을 사용하게 되면 데이터 베이스에 영향을 끼치지 않음
    @Transactional
    public void delete() {

        Optional<User> user = userRepository.findById(3L);

        // 데이터 2번을 select 했을 때 반드시 데이터가 존재해야 하기 때문에
        // assert 라는 junit 패키지 아래 반드시 user은 isPresent 메소드가 반드시 True여야 한다 이과정을 통과해야함
        // 만약에 데이터가 없다면 assertTrue 값이 false가 되기 때문에 에러가 나게 된다
        assertTrue(user.isPresent());

        // delete는 데이터가 지워졌기 때문에 반환이 없다
        user.ifPresent(selectUser -> userRepository.delete(selectUser));

        Optional<User> deleteUser = userRepository.findById(3L);

        assertFalse(deleteUser.isPresent()); // 삭제된 데이터는 반드시 false여야 한다
    }
}
