package hello.core.member;

import hello.core.Appconfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, Grade.VIP, "memberA");

        // when
        memberService.join(member);
        Member fineMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(fineMember);
    }
}
