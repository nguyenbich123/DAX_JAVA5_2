package com.poly.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;
import com.poly.entity.Role;


public interface AccountDAO extends JpaRepository<Account,String>{
	 Optional<Account> findByTenDN(String username);
	 
	 Optional<Account> findByEmail(String email);
	 
	 Page<Account> findByRole(Pageable pageable,Optional<Role> role);
}
