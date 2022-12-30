package min.order;

import min.core.AppConfig;
import min.core.member.Member;
import min.core.member.MemberService;
import min.core.order.Order;
import min.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static min.core.member.Grade.HIGHEST;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Member member = new Member(1L, "황기태", 50L, HIGHEST);
        memberService.register(member);

        Order order = orderService.makeOrder(1L, "산삼", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }



}