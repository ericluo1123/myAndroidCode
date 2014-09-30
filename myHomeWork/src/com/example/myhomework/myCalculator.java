package com.example.myhomework;

public class myCalculator {

	private char operator;
	private double result;
	private double value;
	private boolean checkValue;

	myCalculator() {
		this.result = 0;
		this.value = 0;
		this.checkValue = false;
		this.operator = 0;
	}

	public double getResult() {
		return this.result;
	}

	public void setResult(double value, char operator) {
		if (checkValue == false) {
			if (operator == '=') {
				this.result = value;
			} else {
				this.value = value;
				this.checkValue = true;
				this.operator = operator;
			}
		} else {
			this.result = this.value;	
			if (operator == '=') {
				this.value = 0;
				this.checkValue = false;
				this.operator = 0;
				this.result=0;
			
			} else {
				this.value = value;
				switch (this.operator) {
				case '+':
					this.result += this.value;
					break;
				case '-':
					this.result -= this.value;
					break;
				case '*':
					this.result *= this.value;
					break;
				case '/':
					this.result /= this.value;
					break;
				}
				this.operator = operator;
			}

			
		}
	}


	public void clearResult() {
		this.result = 0;
		this.value = 0;
		this.checkValue = false;
		this.operator = 0;
	}
}
