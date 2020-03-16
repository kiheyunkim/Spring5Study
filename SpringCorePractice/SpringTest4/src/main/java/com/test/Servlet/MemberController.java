package com.test.Servlet;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.member.Member;
import com.test.member.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	private final MemberService memberService;
	
	@Lazy
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping("add")
	public String addMember(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests",memberService.list());
		
		return "memberList";
	}
	
	
	@RequestMapping(value = {"remove","delete"},method = RequestMethod.GET)
	public String removeMember(@RequestParam("memberName")String memberName) {
		memberService.remove(memberName);
		return "redirect";
	}
		
	
	@RequestMapping("display/{member}")
	public String displayMember(@PathVariable("member")String member, Model model) {
		System.out.println("hi");
		//model.addAttribute("member",memberService.find(member).orElse(null));
		return "member";
	}
	
	@RequestMapping
	public void memberList() {
		
	}
	
	public void memberLogic(String memberName) {
		
	}
}
