package com.teamsourcing.LoongyeeApp.main;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/3
 * Time: 上午 11:59
 * To change this template use File | Settings | File Templates.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.*;
import com.teamsourcing.LoongyeeApp.controls.Carousel;
import com.teamsourcing.LoongyeeApp.controls.CarouselAdapter;
import com.teamsourcing.LoongyeeApp.controls.CarouselAdapter.OnItemClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    int click = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout linear1, linear2;
        linear1 = (LinearLayout)findViewById(R.id.linearlayout1);
        linear2 = (LinearLayout)findViewById(R.id.linearlayout2);
        linear1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,TemperatureHumidityActivity.class);

                        startActivity(intent);
                        finish();
                    }
                }
        );
        linear2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this,TemperatureHumidityActivity.class);

                        startActivity(intent);
                        finish();
                    }
                }
        );

        Carousel carousel = (Carousel)findViewById(R.id.carousel);
        TextView text = (TextView)findViewById(R.id.textview_name);
        carousel.setText(text);
        Intent intent=getIntent();
        String value=intent.getStringExtra("ItemNo");
        if(value != null)
        {
            if(!value.equals(""))
            {
                carousel.setSelection(Integer.parseInt(value));
            }
        }


        carousel.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(CarouselAdapter<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "Position=" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                if (position == 2){
//              intent.setClass(MainActivity.this,ListImagesActivity.class);
//
//                    intent.setClass(MainActivity.this,ExpandablelistSwitchActivity.class);
//
//                    startActivity(intent);
//                    finish();


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

                        intent.setClass(MainActivity.this,ExpandablelistSwitchActivity.class);

                        startActivity(intent);
                        finish();
                    }
                    catch (Exception e)
                    {
                        //Log.e("Device", "exception", e);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("ERROR")
                                .setMessage(MainActivity.this.getString(R.string.msg2))
                                .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id) {

                                        dialog.cancel();
                                    }
                                })
                                .show();
                    }

                }else if(position == 4){

                    intent.setClass(MainActivity.this,SettingLoginActivity.class);

                    startActivity(intent);
                    finish();
                }

                else if(position == 0){

                    intent.setClass(MainActivity.this,TemperatureHumidityActivity.class);

                    startActivity(intent);
                    finish();
                }else if (position == 1){

                    intent.setClass(MainActivity.this,MonitorActivity.class);

                    startActivity(intent);
                    finish();
                }else if (position == 5){

                    intent.setClass(MainActivity.this,PlugActivity.class);

                    startActivity(intent);
                    finish();
                }
                else if(position == 3){
                    intent.setClass(MainActivity.this,ApplianceActivity.class);

                    startActivity(intent);
                    finish();
                }

            }

        });

    }

    public void onBackPressed(){

        if(click == 0)
        {
            click++;
            Toast.makeText(MainActivity.this,MainActivity.this.getString(R.string.msg4), Toast.LENGTH_SHORT).show();
        }
        else
        {
            System.exit(0);
            super.onBackPressed();
        }

        //super.onBackPressed();
    }
}
