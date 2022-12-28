package min.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemMemberRepository();

    @Override
    public void register(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
