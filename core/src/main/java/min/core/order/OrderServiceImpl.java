package min.core.order;

import min.core.discount.Discount;
import min.core.member.Member;
import min.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    //    private final Discount discount = new FixDiscount();
    private final Discount discount;

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, Discount discount) {
        this.memberRepository = memberRepository;
        this.discount = discount;
    }

    @Override
    public Order makeOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int salePrice = discount.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, salePrice);
    }
}
