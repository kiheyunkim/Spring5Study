package com.example.demo.repository;

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
	public void optional() throws Exception{
		Optional<Account> notnullOpt = accountRepository.findByUserName("userName");
		System.out.println(notnullOpt.isPresent());
		Account account = notnullOpt.get();
		System.out.println(account);
		
		Optional<Account> nullOpt = accountRepository.findByUserName("test");
		System.out.println(nullOpt.isPresent());
		
		Optional<Account> notnullOpt2 = accountRepository.findByUserName("tet");
		System.out.println(notnullOpt2.isPresent());
		Account acct1 = notnullOpt2.orElse(new Account());
		System.out.println(acct1);
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
