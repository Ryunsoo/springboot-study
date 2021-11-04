package com.kh.toy.member;

import com.kh.toy.member.validator.JoinForm;

public interface MemberRepository {

	void insertMember(JoinForm form);

	Member authenticateUser(Member member);

	Member selectMemberByUserId(String userId);

}
