package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        Appconfig appconfig = new Appconfig();
//        MemberService memberService = appconfig.memberService();
//        OrderService orderService = appconfig.orderService();

//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService = (MemberService) applicationContext.getBean("memberService");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");

        Long memberId = 1L;
        Member member = new Member(memberId, Grade.VIP, "memberA");
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " +  order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
