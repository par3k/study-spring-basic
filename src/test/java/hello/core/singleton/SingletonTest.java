package hello.core.singleton;

import hello.core.Appconfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer() {
        Appconfig appconfig = new Appconfig();

        //1. 조회
        MemberService memberService1 = appconfig.memberService();

        //2. 조회
        MemberService memberService2 = appconfig.memberService();

        //참조 값이 다른 것을 확인
        System.out.println(memberService1);
        System.out.println(memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1: " + singletonService1);
        System.out.println("singletonService2: " + singletonService2);

        // same : ==과 동일
        // equal : equal과 동일
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainerTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조 값이 다른 것을 확인
        System.out.println(memberService1);
        System.out.println(memberService2);

        // memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
