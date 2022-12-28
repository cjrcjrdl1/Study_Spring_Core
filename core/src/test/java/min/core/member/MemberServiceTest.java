package min.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static min.core.member.Grade.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "황기태", 50L, HIGHEST);

        //when
        memberService.register(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

}