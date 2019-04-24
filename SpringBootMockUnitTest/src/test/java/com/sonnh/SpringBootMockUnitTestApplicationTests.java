package com.sonnh;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockUnitTestApplicationTests {


	@Test
	public void calculateSum() {
		Calculation calculation = new Calculation();
		int a = 9;
		int b = 10;
		int c = calculation.sum(a, b);
		assertEquals(19, c);
		assertEquals(9, calculation.sum(4, 5));
	}

}

