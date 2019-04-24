package com.sonnh.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sonnh.dao.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO accountDAO;

	@Transactional(rollbackForClassName="Exception")
	public void transfer(int sourceId, int targetId, BigDecimal amount) {
		BigDecimal sourceAmount = accountDAO.getCurrentAmount(sourceId);
		BigDecimal targetAmount = accountDAO.getCurrentAmount(targetId);
		
		//add target
		accountDAO.updateAmount(targetId, targetAmount.add(amount));
		
		//subtract source
		accountDAO.updateAmount(sourceId, sourceAmount.subtract(amount));
	}

}
