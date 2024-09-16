package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(null);

        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService = (MemberService) context.getBean("memberService");

        Member member = new Member(1L, Grade.VIP, "memberA");
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "  + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
