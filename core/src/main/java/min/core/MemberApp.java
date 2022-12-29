package min.core;

import min.core.member.Grade;
import min.core.member.Member;
import min.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "황기태", 50L, Grade.HIGHEST);
        memberService.register(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember.getName() = " + findMember.getName());
    }
}
