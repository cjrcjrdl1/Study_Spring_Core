package min.core.discount;

import min.core.member.Grade;
import min.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static min.core.member.Grade.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountTest {

    RateDiscount discount = new RateDiscount();

    @Test
    @DisplayName("HIGHEST 는 10퍼센트 세일")
    void highest_true() {
        Member member = new Member(1L, "highest", 10L, HIGHEST);
        int discountPrice = discount.discount(member, 10000);
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("HIGHEST 아니면 할인 적용 X")
    void highest_false() {
        Member member = new Member(2L, "normal", 12L, NORMAL);
        int discountPrice = discount.discount(member, 10000);
        assertThat(discountPrice).isEqualTo(0);
    }

}