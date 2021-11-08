package com.kh.toy.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.toy.member.validator.JoinForm;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MemberControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("아이디 중복 검사 테스트 - 성공")
	public void idCheckWithSuccess() throws Exception {
		
		mockMvc.perform(get("/member/id-check")
				.param("userId", "lastPclass"))
		.andExpect(content().string("available"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("아이디 중복 검사 테스트 - 성공")
	public void idCheckWithFail() throws Exception {
		
		mockMvc.perform(get("/member/id-check")
				.param("userId", "test"))
		.andExpect(content().string("disable"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("이메일 발송 이후 회원 가입")
	public void joinImpl() throws Exception {
		
		for (int i = 0; i < 10; i++) {
			JoinForm joinForm = new JoinForm();
			joinForm.setUserId("test" + i);
			joinForm.setPassword("1234qwe!@#");
			joinForm.setTell("010-2222-3333");
			joinForm.setEmail("babyfox225@gmail.com");
			
			mockMvc.perform(get("/member/join-impl/1234")
					.sessionAttr("persistToken", "1234")
					.sessionAttr("persistUser", joinForm))
			.andExpect(status().is3xxRedirection())
			.andDo(print());
		}
		
	}
	
	@Test
	@DisplayName("로그인 - 성공")
	public void loginWithSuccess() throws Exception {
		
		mockMvc.perform(post("/member/login")
				.param("userId", "pclass")
				.param("password", "1234asd!@#"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/member/mypage"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("로그인 - 실패")
	public void loginWithFails() throws Exception {
		
		mockMvc.perform(post("/member/login")
				.param("userId", "fbstn")
				.param("password", "1234asd!@#"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/member/login"))
		.andDo(print());
	}
	
}
