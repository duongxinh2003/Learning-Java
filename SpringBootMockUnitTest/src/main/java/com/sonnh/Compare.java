package com.sonnh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Compare {

//	@Autowired
//	private ICalculation calculation;
	
	private Calculation calculation;
	
	public boolean check(int a, int b) {
		int sum = calculation.sum(a, b);
		return sum > 10 ;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}
}
