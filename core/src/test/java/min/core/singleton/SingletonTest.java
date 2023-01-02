package min.core.singleton;

import min.core.AppConfig;
import min.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);

        //이렇게 계속 객체를 생성하면 메모리 낭비가 심하기에 객체를 한개만 생성하고 공유하도록 설계
        //이를 싱글톤 패턴이라고 함
    }

    @Test
    @DisplayName("싱글톤 패턴 적용")
    public void singletonServiceTest() {
//        new SingletonService(); 객체 생성 못하게 private으로 막혀있음
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();

        //싱글톤 패턴의 문제점
        //싱글톤 패턴을 구현하는 코드 자체가 많이 들어감
        //의존관계상 클라이언트가 구체 클래스 의존 -> DIP 위반
        //구체 클래스 의존으로 OCP 위반 가능성 높음
        //내부속성을 변경하거나 초기화하기 어려움
        //private 생성자로 자식 클래스를 만들기 어려움
        //유연성이 떨어지고 안티패턴으로 불리기도 함
    }
}
