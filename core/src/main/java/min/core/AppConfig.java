package min.core;

import min.core.discount.Discount;
import min.core.discount.FixDiscount;
import min.core.member.MemMemberRepository;
import min.core.member.MemberRepository;
import min.core.member.MemberService;
import min.core.member.MemberServiceImpl;
import min.order.OrderService;
import min.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discount());
    }

    public MemberRepository memberRepository() {
        return new MemMemberRepository();
    }

    public Discount discount() {
        return new FixDiscount();
    }
}
