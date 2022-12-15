package core.rensyu;

import core.rensyu.member.Grade;
import core.rensyu.member.Member;
import core.rensyu.member.MemberService;
import core.rensyu.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 会員情報保存
        Member findMember = memberService.findMember(1L); // 会員情報検索
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

/*
会員情報保存流れ
memberService.join(member);　-> MemberServiceファイル ->  MemberServiceImplファイル ->
memberRepository.save(member); -> MemberRepositoryファイル　-> MemoryMemberRepositoryファイル　->
MAPに保存

会員情報検索流れ
memberService.findMember(1L); -> MemberServiceファイル -> MemberServiceImplファイル ->
memberRepository.findById(memberId); -> MemberRepositoryファイル　-> MemoryMemberRepositoryファイル　->
store.get(memberId)から情報取得

MemberServiceTestファイル参照
*/
