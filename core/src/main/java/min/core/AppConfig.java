package min.core;

import min.core.discount.Discount;
import min.core.discount.FixDiscount;
import min.core.discount.RateDiscount;
import min.core.member.MemMemberRepository;
import min.core.member.MemberRepository;
import min.core.member.MemberService;
import min.core.member.MemberServiceImpl;
import min.order.OrderService;
import min.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discount());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemMemberRepository();
    }

    @Bean
    public Discount discount() {
//        return new FixDiscount();
        return new RateDiscount();
    }
}
