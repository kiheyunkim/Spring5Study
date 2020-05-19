package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void otherMethod() {
		List<String> list = new ArrayList<String>();
		list.add("하이");
		list.add("안녕");
		
		//Consumer가 가진 추상메서드를 void accept(T t)
		System.out.println("Method Reference");
		list.forEach(val->System.out.println(val));
		
		//Method Reference
		System.out.println("Method Reference");
		list.forEach(System.out::println);
	}
	
	@Test
	public void optional() throws Exception{
		Optional<Account> notnullOpt = accountRepository.findByUserName("userName");
		System.out.println(notnullOpt.isPresent());
		Account account = notnullOpt.get();
		System.out.println(account);
	}
	
	@Test
	public void optional2() throws Exception{	
		Optional<Account> nullOpt = accountRepository.findByUserName("test");
		System.out.println(nullOpt.isPresent());
	}
	
	@Test
	public void optional3() throws Exception{	
		Optional<Account> notnullOpt2 = accountRepository.findByUserName("tet");
		System.out.println(notnullOpt2.isPresent());
		Account acct1 = notnullOpt2.orElse(new Account());	
		System.out.println(acct1);
	}
	
	@Test
	public void optional4() throws Exception{	
		Optional<Account> notnullOpt2 = accountRepository.findByUserName("test");
		System.out.println(notnullOpt2.isPresent());
		//Account acct1 = notnullOpt2.orElseThrow(()->new RuntimeException("Account not Found"));	
		//System.out.println(acct1);
	}
	
	@Test 
	public void account() throws Exception{
		Account account = new Account();
		account.setId(1L);
		account.setUserName("userName");
		accountRepository.save(account);
		
		//Account account = accountRepository.getOne(id) 
	}
	

}
