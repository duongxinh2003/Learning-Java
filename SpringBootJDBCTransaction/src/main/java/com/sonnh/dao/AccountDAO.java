package com.sonnh.dao;

import java.math.BigDecimal;
import java.util.List;

import com.sonnh.model.Account;

public interface AccountDAO {

	BigDecimal getCurrentAmount(int id);
	
	void updateAmount(int id, BigDecimal amount);
	
	List<Account> getAllAccount();
}
