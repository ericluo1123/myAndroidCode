package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2014/1/9
 * Time: 上午 11:07
 * To change this template use File | Settings | File Templates.
 */



public class LoginActivity extends Activity  implements View.OnClickListener{
    private TextView userlogin;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userlogin = (TextView)findViewById(R.id.userlogin);

    }
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.userlogin){
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();    //To change body of overridden methods use File | Settings | File Templates.
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
