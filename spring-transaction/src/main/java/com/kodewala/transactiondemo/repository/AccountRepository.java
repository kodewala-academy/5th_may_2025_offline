package com.kodewala.transactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.transactiondemo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
