package com.kiheyunkim.kim.member.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiheyunkim.kim.member.model.Member;
import com.kiheyunkim.kim.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private final MemberService memberService;
	
	@Lazy
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = {"add"})
	public String addMemeber(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests",memberService.list());
		return "memberList";
	}
	
	@RequestMapping(value = {"remove","delete"})
	public String removeMember(@RequestParam("member")String member, Model model) {
		memberService.remove(member);
		
		return "redirect";
	}
	
	@RequestMapping(value = {"display/{member}"})
	public String displayMemeber(@PathVariable("member")String member, Model model) {
		model.addAttribute("member",memberService.find(member).orElse(null));
		return "member";
	}
	
	@RequestMapping
	public void memberList() {
	}
	
	public void memberLogic(String memberName) {
		
	}
}
