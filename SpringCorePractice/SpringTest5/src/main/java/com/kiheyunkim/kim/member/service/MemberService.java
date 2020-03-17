package com.kiheyunkim.kim.member.service;

import java.util.List;
import java.util.Optional;

import com.kiheyunkim.kim.member.model.Member;

public interface MemberService{

	void add(Member member);
	
	void remove(String memberName);
	
	List<Member> list();
	
	Optional<Member> find(String member);
}
