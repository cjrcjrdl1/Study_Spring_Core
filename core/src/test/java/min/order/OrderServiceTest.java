package min.order;

import min.core.member.Grade;
import min.core.member.Member;
import min.core.member.MemberService;
import min.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static min.core.member.Grade.HIGHEST;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Member member = new Member(1L, "황기태", 50L, HIGHEST);
        memberService.register(member);

        Order order = orderService.makeOrder(1L, "산삼", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }



}