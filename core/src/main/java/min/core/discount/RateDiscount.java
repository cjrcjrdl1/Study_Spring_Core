package min.core.discount;

import min.core.member.Grade;
import min.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainDiscount")
public class RateDiscount implements Discount {

    private int discountPercent = 10;


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.HIGHEST) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
