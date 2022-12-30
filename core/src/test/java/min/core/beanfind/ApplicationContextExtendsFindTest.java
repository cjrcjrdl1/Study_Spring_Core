package min.core.beanfind;

import min.core.discount.Discount;
import min.core.discount.FixDiscount;
import min.core.discount.RateDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 존재하면 중복오류 발생")
    void findBeanByParentTypeDuplicate() {
//        Discount bean = ac.getBean(Discount.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(Discount.class));
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscount bean = ac.getBean(RateDiscount.class);
        assertThat(bean).isInstanceOf(RateDiscount.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType() {
        Map<String, Discount> beansOfType = ac.getBeansOfType(Discount.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("Object를 이용하여 모두 조회")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public Discount rateDiscount() {
            return new RateDiscount();
        }

        @Bean
        public Discount fixDiscount() {
            return new FixDiscount();
        }
    }
}

