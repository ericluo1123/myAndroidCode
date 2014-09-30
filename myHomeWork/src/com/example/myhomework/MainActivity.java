package com.example.myhomework;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private myCalculator myCalculator;
	private EditText editText;
	private boolean first;
	private boolean dot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Parse.initialize(this, "6GIweBfY6S45aUHHhzAkw4cgo6Cb7PlvUyYYwJFs",
		// "nEFIK6PmEiidO3qnyvPa04WCi9rJCECOvN8qg5vf");
		//
		// Parse.initialize(this, "7l5Z9eV6OxMQib9gma1hzQZin3oDjmxmckBqNnbe",
		// "3bWeunqIQJVudejWipAx2yUB15KmnqYunILxyy0G");
		//
		// ParseObject parseObject = new ParseObject("hw2");
		// parseObject.put("sid", "And24509");
		// parseObject.saveInBackground();

		setContentView(R.layout.activity_main);
		myCalculator = new myCalculator();
		first = false;
		dot = false;
		editText = (EditText) findViewById(R.id.editText1);
		editText.setText("0");

	}

	public void setText(View view) {
		if (view.getId() == R.id.button1) {

		} else if (view.getId() == R.id.button2) {

		} else if (view.getId() == R.id.button3) {

		} else if (view.getId() == R.id.button4) {

		} else if (view.getId() == R.id.button5) {
			// 'c'
			editText.setText("0");
		} else if (view.getId() == R.id.button6) {

		} else if (view.getId() == R.id.button7) {
			// '/'
		} else if (view.getId() == R.id.button8) {
			// '*'
		} else if (view.getId() == R.id.button9) {
			// '7'
			sendText("7");
		} else if (view.getId() == R.id.button10) {
			// '8'
			sendText("8");
		} else if (view.getId() == R.id.button11) {
			// '9'
			sendText("9");
		} else if (view.getId() == R.id.button12) {
			// '-'
		} else if (view.getId() == R.id.button13) {
			// '4'
			sendText("4");
		} else if (view.getId() == R.id.button14) {
			// '5'
			sendText("5");
		} else if (view.getId() == R.id.button15) {
			// '6'
			sendText("6");
		} else if (view.getId() == R.id.button16) {
			// '+'
		} else if (view.getId() == R.id.button17) {

		} else if (view.getId() == R.id.button18) {
			// '1'
			sendText("1");
		} else if (view.getId() == R.id.button19) {
			// '0'
			sendText("0");
		} else if (view.getId() == R.id.button20) {
			// '2'
			sendText("2");
		} else if (view.getId() == R.id.button21) {
			// '3'
			sendText("3");
		} else if (view.getId() == R.id.button22) {
			// '.'
			sendText(".");
		}
	}

	private void sendText(String string) {
		// TODO Auto-generated method stub
		String text = editText.getText().toString();
		if (text.equals("0")) {
			if (string.equals(".")) {
				editText.setText(text + string);
			} else {
				editText.setText(string);
			}
		} else {
			if (string.equals(".")) {
				if (text.indexOf('.') == -1) {
					editText.setText(text + string);
				}
			} else {
				editText.setText(text + string);
			}

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
