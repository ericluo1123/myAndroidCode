package com.example.myhomework;

public class myCalculator {

	private char operator;
	private double result;
	private double value1;
	private double value2;
	private boolean checked1;
	private boolean checked2;

	myCalculator() {
		this.result = 0;
		this.value1 = 0;
		this.value2 = 0;
		this.checked1 = false;
		this.checked2 = false;
		this.operator = 0;
	}

	public void setResult(double value) {
		this.result = value;
	}

	public double getResult() {
		return this.result;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}
	
	public char getOperator(){
		return this.operator;
	}

	public void setValue(double value) {
		if (checked2 == false) {
			if (checked1 == false) {
				checked1 = true;
				this.value1 = value;
			} else {
				checked2 = true;
				this.value2 = value;
			}
		}
	}

	public void runOperation() {
		if (checked2 == true) {
			checked2 = false;
			switch (this.operator) {
			case '+':
				this.result = this.value1 + this.value2;
				break;
			case '-':
				this.result = this.value1 - this.value2;
				break;
			case '*':
				this.result = this.value1 * this.value2;
				break;
			case '/':
				this.result = this.value1 / this.value2;
				break;
			}
			this.value1 = this.result;
		}
	}

	public void clearResult() {
		this.result = 0;
		this.value1 = 0;
		this.value2 = 0;
		this.checked1 = false;
		this.checked2 = false;
		this.operator = 0;
	}
}
