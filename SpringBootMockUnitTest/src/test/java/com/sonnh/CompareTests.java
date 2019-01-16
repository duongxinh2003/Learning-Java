package com.sonnh;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompareTests {

	
	@Test
	public void testCheck() {
		Calculation calculationMock = Mockito.mock(Calculation.class);
		Compare compare = new Compare();
		compare.setCalculation(calculationMock);
		Mockito.when(calculationMock.sum(12, 2)).thenReturn(18);
		int a = 0;
		int b = 2;
		boolean c = compare.check(a, b);
		assertEquals(18, calculationMock.sum(12, 2));
		assertEquals(true, c);
	}
}
