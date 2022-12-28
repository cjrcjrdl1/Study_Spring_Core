package min.core.member;

public interface MemberService {
    void register(Member member);

    Member findMember(Long memberId);
}
