package min.core.singleton;

import min.core.AppConfig;
import min.core.member.MemberRepository;
import min.core.member.MemberService;
import min.core.member.MemberServiceImpl;
import min.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
        //같은 인스턴스를 참조한다 (싱글톤)
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //외부에서 주입해주는 AppConfig도 스프링 빈으로 등록됨
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
        //@Bean이 붙은 메서드마다 스프링 빈이 기존에 존재하면 존재하는 빈을 반환하고 없으면 생성ㅇ해서 스프링 빈으로 등록하고 반환
        // Bean만 사용해도 스프링빈으로 등록은 되지만, 싱글톤을 보장X
    }
}
