package com.kh.toy.member.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.toy.member.MemberRepository;

@Component
public class JoinFormValidator implements Validator{

	//JoinForm 타입 객체에 대해 항상 validator가 작동한다.
	//Member를 사용하면 너무 많이 호출되기 때문에 validate만을 위한 JoinForm 객체 생성
	
	private MemberRepository memberRepository;
	
	public JoinFormValidator(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	//validator가 작동해야하는 타입을 검증하여 선택적으로 작동
	@Override
	public boolean supports(Class<?> clazz) {
		return JoinForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JoinForm form = (JoinForm) target;
		
		//1. 아이디 존재 유뮤
		if(memberRepository.selectMemberByUserId(form.getUserId()) != null) {
			errors.rejectValue("userId", "error-userId", "이미 존재하는 아이디입니다.");
		}
		
		//2. 비밀번호가 8글자 이상, 숫자 영문자 특수문자 조합인지 확인
		boolean valid = Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}", form.getPassword());
		if(!valid) {
			errors.rejectValue("password", "error-password", "비밀번호는 8글자 이상의 숫자 영문자 특수문자 조합 입니다.");
		}
		
		//3. 전화번호가 9~11자리의 숫자
		valid = Pattern.matches("^\\d{9,11}$", form.getTell());
		if(!valid) {
			errors.rejectValue("tell", "error-tell", "전화번호는 9~11 자리의 숫자입니다.");
		}
		
	}

}
