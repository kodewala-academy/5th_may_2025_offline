package com.kodewala.transactiondemo.controller;

import com.kodewala.transactiondemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/transfer")
	public String transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam Double amount) {

		accountService.transferMoney(fromId, toId, amount);
		return "Transfer successful";
	}
}
