package hello.core.beanfind;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> context.getBean(MemberRepository.class));
//        MemberRepository memberRepository = context.getBean(MemberRepository.class);

    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanByName() {
        MemberRepository memberRepository = context.getBean("memberRepository1", MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특성 타입을 모두 조회하기")
    void findAllBeanByType() {
    Map<String, MemberRepository> beanOfType = context.getBeansOfType(MemberRepository.class);
    for (String key : beanOfType.keySet()) {
        System.out.println("key = " + key + ", value = " + beanOfType.get(key));
    }
        System.out.println("beanOfType = " + beanOfType);
        org.assertj.core.api.Assertions.assertThat(beanOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
