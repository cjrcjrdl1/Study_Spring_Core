package min.core.discount;

import min.core.member.Member;

public interface Discount {
    int discount(Member member, int price);
}
