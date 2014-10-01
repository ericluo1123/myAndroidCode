package com.example.myhomework;

import android.util.Log;

public class myCalculator {

	private char operator;
	private int result;
	private int value1;
	private int value2;
	private boolean saveValue;

	myCalculator() {
		this.result = 0;
		this.value1 = 0;
		this.value2 = 0;
		this.saveValue = false;
		this.operator = 0;
	}

	public int getResult() {
		return this.result;
	}

	public void clearResult() {
		this.result = 0;
		this.value1 = 0;
		this.value2 = 0;
		this.saveValue = false;
	}

	public void setResult(int value, char operator) {
		if (saveValue == false) {
			this.value1 = value;
			if (operator == '=') {
				this.result = value;
			} else {
				this.saveValue = true;
				this.operator = operator;
			}
		} else {
			this.value2 = value;
			if (operator == '=') {
				this.saveValue = false;
				this.result = getComputing();
			} else {
				this.value1 = getComputing();
				this.operator = operator;
			}
		}
	}

	private int getComputing() {
		int result = 0;
		switch (this.operator) {
		case '+':
			result = this.value1 + this.value2;
			break;
		case '-':
			result = this.value1 - this.value2;
			break;
		case '*':
			result = this.value1 * this.value2;
			break;
		case '/':
			try {
				result = this.value1 / this.value2;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.d("debug", "無法除0");
			}
			break;
		}
		return result;
	}
}
