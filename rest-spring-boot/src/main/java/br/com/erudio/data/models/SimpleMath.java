package br.com.erudio.data.models;

import org.springframework.stereotype.Service;

@Service
public class SimpleMath {
	
	public double sum(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public double subtraction(double numberOne, double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public double multiply(double numberOne, double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public double divide(double numberOne, double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public double average(double numberOne, double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	
	public double squareRoot(double number) {
		return Math.sqrt(number);
	}

}
