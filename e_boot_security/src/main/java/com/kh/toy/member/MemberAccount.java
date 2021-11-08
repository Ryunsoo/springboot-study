package com.kh.toy.member;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MemberAccount extends User{

	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	public MemberAccount(Member member) {
		super(member.getUserId()
				, member.getPassword()
				, List.of(new SimpleGrantedAuthority(member.getGrade())));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
	public String getEmail() {
		return member.getEmail();
	}
	
	public String getTell() {
		return member.getTell();
	}
	
}
