package hello.core.order;

import hello.core.Appconfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
        orderService = appconfig.orderService();
    }

    @Test
    void createOrder() {
        Long memerId = 1L;
        Member member = new Member(memerId, Grade.VIP, "memberA");
        memberService.join(member);

        Order order = orderService.createOrder(memerId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}