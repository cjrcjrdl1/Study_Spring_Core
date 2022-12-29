package min.core;

import min.core.member.Grade;
import min.core.member.Member;
import min.core.member.MemberService;
import min.order.Order;
import min.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "황기태", 50L, Grade.HIGHEST);
        memberService.register(member);

        Order order = orderService.makeOrder(memberId, "서적", 10000);

        System.out.println("order = " + order);
    }
}
