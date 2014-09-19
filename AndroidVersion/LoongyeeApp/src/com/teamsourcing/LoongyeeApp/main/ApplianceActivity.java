package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by teamsourcing on 2014/7/1.
 */
public class ApplianceActivity extends Activity implements View.OnClickListener{
    private Button backBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);

        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        if(v.getId() == R.id.backBtn){

            Intent intent = new Intent();
            intent.putExtra("ItemNo", String.valueOf(3));
            intent.setClass(ApplianceActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }

    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(3));
        intent.setClass(ApplianceActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }

}

