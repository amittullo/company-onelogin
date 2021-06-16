package com.onelogin.calculator;

import org.junit.Assert;
import org.junit.Test;

public class OneLoginExerciseTest {

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentLength2() {
		String[] args = { "2", "3" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentLength4() {
		String[] args = { "2", "3", "*", "6" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentOrder1() {
		String[] args = { "2", "3", "*" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentOrder2() {
		String[] args = { "*", "3", "6" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentOperator1() {
		String[] args = { "2", "!", "6" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidArgumentOperator2() {
		String[] args = { "2", "$", "6" };
		Calculator calculator = new Calculator();
		calculator.calculate(args);
	}

	@Test
	public void successAdd() {
		String[] args = { "3", "+", "6" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(9.00, result, 0);
	}

	@Test
	public void successAddMixedNumber() {
		String[] args = { "3_3/6", "+", "2_2/3" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(6.166666666666666, result, 0);
	}

	@Test
	public void successSubtract() {
		String[] args = { "3", "-", "6" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(-3.0, result, 0);
	}

	@Test
	public void successSubtractMixedNumber() {
		String[] args = { "3_4/6", "-", "2_2/3" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(1.0, result, 0);
	}

	@Test
	public void successMultiply() {
		String[] args = { "3", "*", "6" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(18, result, 0);
	}

	@Test
	public void successMultiplyMixedNumber() {
		String[] args = { "3_4/6", "*", "2_2/3" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(9.777777777777777, result, 0);
	}

	@Test
	public void successDivide() {
		String[] args = { "3", "/", "6" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(0.5, result, 0);
	}

	@Test
	public void successDivideMixedNumber() {
		String[] args = { "3_4/6", "/", "2_2/3" };
		Calculator calculator = new Calculator();
		double result = calculator.calculate(args);
		Assert.assertEquals(1.375, result, 0);
	}

}
