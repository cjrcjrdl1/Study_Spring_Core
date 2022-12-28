package min.order;

import min.core.discount.Discount;
import min.core.discount.FixDiscount;
import min.core.member.MemMemberRepository;
import min.core.member.Member;
import min.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemMemberRepository();
    private final Discount discount = new FixDiscount();


    @Override
    public Order makeOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int salePrice = discount.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, salePrice);
    }
}
