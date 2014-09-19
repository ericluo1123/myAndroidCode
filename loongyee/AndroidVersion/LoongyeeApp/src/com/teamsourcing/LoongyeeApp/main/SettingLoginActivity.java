package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by teamsourcing on 2014/4/21.
 */
public class SettingLoginActivity extends Activity{

    public final static float[] BT_SELECTED=new float[] {
            2, 0, 0, 0, 0.8f,
            0, 2, 0, 0, 0.8f,
            0, 0, 2, 0, 2,
            0, 0, 0, 1, 0 };
    public final static float[] BT_NOT_SELECTED=new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0 };

        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.setting_login);


            Button login = (Button) findViewById(R.id.button_login);
            login.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

//                            Intent intent = new Intent();
//                            intent.setClass(SettingLoginActivity.this, SettingLearningActivity.class);
//
//                            startActivity(intent);
//                            finish();
                            String url = Constants.IP +"cgi-bin/uci_show?data=device";
                            HttpURLConnection httpConn = null;
                            try
                            {
                                httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                httpConn.setRequestMethod("GET");
                                httpConn.setDoOutput(true);// 是否輸入參數
                                httpConn.setConnectTimeout(8000);
                                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                httpConn.disconnect();
                                Intent intent = new Intent();
                                intent.setClass(SettingLoginActivity.this,SearchDeviceActivity.class);

                                startActivity(intent);
                                finish();
                            }
                            catch (Exception e)
                            {
                                //Log.e("Device", "exception", e);
                                new AlertDialog.Builder(SettingLoginActivity.this)
                                        .setTitle("ERROR")
                                        .setMessage( SettingLoginActivity.this.getString(R.string.msg2))
                                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id) {

                                                dialog.cancel();
                                            }
                                        })
                                        .show();
                            }
                        }
                    }
            );

            final Button Back = (Button) findViewById(R.id.back);
            Back.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("ItemNo", String.valueOf(4));
                            intent.setClass(SettingLoginActivity.this, MainActivity.class);

                            startActivity(intent);
                            finish();
                        }
                    }
            );
            Back.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View arg0, MotionEvent motionEvent) {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                        Back.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
                        Back.setBackgroundDrawable(Back.getBackground());
                    }
                    else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                        Back.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
                        Back.setBackgroundDrawable(Back.getBackground());
                    }
                    return false;
                }
            });
        }
    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(4));
        intent.setClass(SettingLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
