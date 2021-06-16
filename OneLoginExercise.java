package com.onelogin.calculator;

import java.util.function.Function;

class Calculator {
	public double calculate(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("Invalid input. Example: '2 + 3' or '4 / 5' or '6 * 7' or '8 - 9'");
		}

		// Calculate operands
		double operand1 = args[0].contains("/") ? TO_NUMBER.apply(args[0]) : Double.parseDouble(args[0]);
		double operand2 = args[2].contains("/") ? TO_NUMBER.apply(args[2]) : Double.parseDouble(args[2]);

		// Perform operation
		switch (args[1]) {
		case "+": // Add
			return operand1 + operand2;
		case "-": // Subtract
			return operand1 - operand2;
		case "*": // Multiply
			return operand1 * operand2;
		case "/": // Divide
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator. Valid operators are +, -, * and /");
		}
	}

	/**
	 * Convert mixed number to double
	 */
	private Function<String, Double> TO_NUMBER = (argument) -> {
		String[] fractions = argument.split("/");
		if (fractions[0].contains("_")) {
			String[] whole = fractions[0].split("_");
			return ((Double.parseDouble(fractions[1]) * Double.parseDouble(whole[0])) + Double.parseDouble(whole[1]))
					/ Double.parseDouble(fractions[1]);
		} else {
			return Double.parseDouble(fractions[0]) / Double.parseDouble(fractions[1]);
		}
	};
}

public class OneLoginExercise {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate(args));
	}

}
