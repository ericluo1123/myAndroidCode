package com.example.myhomework;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

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