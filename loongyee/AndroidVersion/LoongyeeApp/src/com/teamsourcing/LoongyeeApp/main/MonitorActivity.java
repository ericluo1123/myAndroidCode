package com.teamsourcing.LoongyeeApp.main;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MonitorActivity extends Activity implements View.OnClickListener{

	private Button backBtn = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monitor);
		
		 backBtn = (Button)findViewById(R.id.backBtn);
		 backBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.backBtn){
			
			Intent intent = new Intent();
            intent.putExtra("ItemNo", String.valueOf(1));
            intent.setClass(MonitorActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
			
		}
		
	}
	
	@Override
	public void onBackPressed(){
		
		Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(1));
        intent.setClass(MonitorActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        
		super.onBackPressed();		
	}

}
