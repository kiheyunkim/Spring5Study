package com.kiheyunkim.kim.member.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;
import com.kiheyunkim.kim.member.model.Member;

@Service
public class MemberServiceImp implements MemberService {

	private Map<String, Member> members = new TreeMap<String, Member>(); 
	
	@Override
	public void add(Member member) {
		members.put(member.getName(), member);
	}

	@Override
	public void remove(String memberName) {
		members.remove(memberName);		
	}

	@Override
	public List<Member> list() {
		List<Member> list = java.util.Collections.emptyList();
		list.addAll(members.values());
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Optional<Member> find(String member) {
		Optional<Member> find = Optional.of(members.get(member)); 
		// TODO Auto-generated method stub
		return find;
	}

}
