package com.example.simplefragment;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Activity3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Toast.makeText(this, "Activity3", Toast.LENGTH_SHORT).show();
		setResult(RESULT_OK);
	}

}
