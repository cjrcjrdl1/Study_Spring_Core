package min.core;

import min.core.discount.FixDiscount;
import min.core.member.MemMemberRepository;
import min.core.member.MemberService;
import min.core.member.MemberServiceImpl;
import min.order.OrderService;
import min.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemMemberRepository(),
                new FixDiscount(
                ));
    }
}
