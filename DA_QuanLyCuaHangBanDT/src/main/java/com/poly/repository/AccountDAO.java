package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;

public interface AccountDAO extends JpaRepository<Account,String>{
	 Optional<Account> findByTenDN(String username);
}
