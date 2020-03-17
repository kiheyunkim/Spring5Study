package com.kiheyunkim.kim.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiheyunkim.kim.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
