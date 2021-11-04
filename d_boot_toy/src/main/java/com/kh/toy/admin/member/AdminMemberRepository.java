package com.kh.toy.admin.member;

import java.util.List;

import com.kh.toy.member.Member;

public interface AdminMemberRepository {

	List<Member> selectAllMembers();
}
