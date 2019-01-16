package com.sonnh.service;

import java.math.BigDecimal;

public interface AccountService {
	void transfer(int sourceId, int targetId, BigDecimal amount);
}
