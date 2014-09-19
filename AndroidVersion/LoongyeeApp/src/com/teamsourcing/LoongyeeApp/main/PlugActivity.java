package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2014/1/22
 * Time: 下午 5:26
 * To change this template use File | Settings | File Templates.
 */
public class PlugActivity extends Activity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plugset);


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.putExtra("ItemNo", String.valueOf(5));
            intent.setClass(PlugActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();    //To change body of overridden methods use File | Settings | File Templates.
        Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(5));
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

