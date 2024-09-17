package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    // 수동 빈 등록이 우선권을 갖음. 자동 생성 빈을 오버라이딩함.
//    @Bean(name = "memoryMemberRepository")
//    public MemoryMemberRepository memoryMemberRepository() {
//        return new MemoryMemberRepository();
//    }
}
