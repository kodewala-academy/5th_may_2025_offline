package com.kodewala.transactiondemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodewala.transactiondemo.controller.AccountController;
import com.kodewala.transactiondemo.entity.Account;
import com.kodewala.transactiondemo.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {

		Optional<Account> fromOpt = accountRepository.findById(fromAccountId);
		Optional<Account> toOpt = accountRepository.findById(toAccountId);

		if (!fromOpt.isPresent()) {
			throw new RuntimeException("Sender not found");
		}
		if (!toOpt.isPresent()) {
			throw new RuntimeException("Receiver not found");
		}

		Account from = fromOpt.get();
		Account to = toOpt.get();

		if (from.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance");
		}

		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);

		accountRepository.saveAll(List.of(from, to));

		System.out.println("AccountService.transferMoney().. Both account's record updated...");

		// Simulate error to test rollback
		if (amount > 5000) {
			throw new RuntimeException("Transfer limit exceeded - triggering rollback");
		}
	}
}
