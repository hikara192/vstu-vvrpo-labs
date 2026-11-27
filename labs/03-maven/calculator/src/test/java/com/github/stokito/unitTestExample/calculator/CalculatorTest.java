package com.github.stokito.unitTestExample.calculator;

import junit.framework.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		// Given
		Calculator calculator = new Calculator();
		// When
		int result = calculator.sum(2, 2);
		// Then
		if (result != 4) {   // if 2 + 2 != 4
			Assert.fail();
		}
	}

	@Test
	public void testMinus() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(0, calculator.minus(2, 2));
	}

	@Test
	public void testMultiply() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(42, calculator.multiply(6, 7));
	}

	@Test
	public void testPower() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(1024, calculator.power(2, 10));
	}

	@Test
	public void testPercent() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(250.0, calculator.percent(1000, 25), 0.0001);
	}

	@Test
	public void testDivide() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(2, calculator.divide(6, 3));
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideWillThrowExceptionWhenDivideOnZero() {
		Calculator calculator = new Calculator();
		calculator.divide(6, 0);
	}
}
