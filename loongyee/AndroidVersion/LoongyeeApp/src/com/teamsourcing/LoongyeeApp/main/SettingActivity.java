package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.teamsourcing.LoongyeeApp.Properties;
//import com.teamsourcing.LoongyeeApp.telnet.socketservice;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2014/1/9
 * Time: 下午 3:37
 * To change this template use File | Settings | File Templates.
 */
public class SettingActivity extends Activity implements View.OnClickListener{
    private Button connpassword;
    private Button adminpassword;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        connpassword = (Button)findViewById(R.id.connpassword);
        adminpassword = (Button)findViewById(R.id.adminpassword);
    }
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.setClass(SettingActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.connpassword){
            LayoutInflater inflater = this.getLayoutInflater();
            View editView = inflater.inflate(R.layout.connpassword, null);
            connpassword = (Button) editView.findViewById(R.id.connpassword);
            new AlertDialog.Builder(this)
                    .setView(editView)
                    .setPositiveButton(R.string.alert_cancel, null)
                    .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                        }
                    }).show();

        }else if (view.getId() == R.id.adminpassword){
            LayoutInflater inflater = this.getLayoutInflater();
            View editView = inflater.inflate(R.layout.adminpassword, null);
            adminpassword = (Button) editView.findViewById(R.id.adminpassword);
            new AlertDialog.Builder(this)
                    .setView(editView)
                    .setPositiveButton(R.string.alert_cancel, null)
                    .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                        }
                    }).show();

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
