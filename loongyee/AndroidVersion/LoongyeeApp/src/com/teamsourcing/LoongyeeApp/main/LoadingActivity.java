package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import com.teamsourcing.LoongyeeApp.telnet.socketservice;

import java.io.UnsupportedEncodingException;
//import com.teamsourcing.LoongyeeApp.Properties;
//import com.teamsourcing.LoongyeeApp.R;
/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/4
 * Time: 下午 11:53
 * To change this template use File | Settings | File Templates.
 */
public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.loading);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0);
            }
        }.start();

    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent();
            intent.setClass(LoadingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
