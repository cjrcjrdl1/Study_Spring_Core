package min.core.discount;

import min.core.member.Grade;
import min.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscount implements Discount{

    private int discountPrice = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.HIGHEST) {
            return discountPrice;
        } else {
            return 0;
        }
    }
}
