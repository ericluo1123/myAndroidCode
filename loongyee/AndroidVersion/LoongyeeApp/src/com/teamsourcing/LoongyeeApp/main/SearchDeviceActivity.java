package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.ColorMatrixColorFilter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import android.view.MotionEvent;
import java.net.URL;

/**
 * Created by teamsourcing on 2014/4/30.
 */
public class SearchDeviceActivity extends Activity {

    Animation alphaAnimation;
    private TextView text1, text2;
    private Button btn;
    private String message="", message2="";

    public final static float[] BT_SELECTED=new float[] {
            2, 0, 0, 0, 100,
            0, 2, 0, 0, 50,
            0, 0, 2, 0, 2,
            0, 0, 0, 1, 0 };
    public final static float[] BT_NOT_SELECTED=new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0 };
    public final static float[] BT_SELECTED2=new float[] {
            2, 0, 0, 0, 0.8f,
            0, 2, 0, 0, 0.8f,
            0, 0, 2, 0, 2,
            0, 0, 0, 1, 0 };
    public final static float[] BT_NOT_SELECTED2=new float[] {
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0 };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_device);

        text1 = (TextView)findViewById(R.id.textview_search);
        text2 = (TextView)findViewById(R.id.textview_period);
        btn = (Button)findViewById(R.id.button_refresh);

        text1.setText("");
        text2.setText("");

        alphaAnimation = new AlphaAnimation(0.2f,1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.RESTART);

        SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
        SharedPreferences images = getSharedPreferences(Constants.IMAGES, 0);
        sort.edit().clear().commit();
        images.edit().clear().commit();

        RunLearning();

        /*
        int Learnstatus =CheckLearning();
        AlertDialog.Builder builder = new AlertDialog.Builder(SearchDeviceActivity.this);
        if(Learnstatus == 1)
        {

            builder.setTitle(R.string.cleardata);

            builder.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                            String url = Constants.IP+"cgi-bin/spi_learning?enable=1&refresh=1";

                            HttpURLConnection httpConn = null;
                            try
                            {
                                httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                httpConn.setRequestMethod("GET");
                                httpConn.setDoOutput(true);// 是否輸入參數
                                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                String str = reader.readLine();
                                message = str;

                                if(!str.equals("Success"))
                                {
                                    new AlertDialog.Builder(SearchDeviceActivity.this)
                                            .setTitle("ERROR")
                                            .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent intent = new Intent();
                                                    intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            })
                                            .show();
                                }
                                httpConn.disconnect();

                            }
                            catch (Exception e)
                            {
                            }
                            dialog.cancel();
                        }
                    }
            );
            builder.setNegativeButton(R.string.cancel,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String url = Constants.IP+"cgi-bin/spi_learning?enable=1&refresh=0";
                            HttpURLConnection httpConn = null;
                            try
                            {
                                httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                httpConn.setRequestMethod("GET");
                                httpConn.setDoOutput(true);// 是否輸入參數
                                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                String str = reader.readLine();
                                message = str;

                                if(!str.equals("Success"))
                                {
                                    new AlertDialog.Builder(SearchDeviceActivity.this)
                                            .setTitle("ERROR")
                                            .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent intent = new Intent();
                                                    intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            })
                                            .show();
                                }
                                httpConn.disconnect();

                            }
                            catch (Exception e)
                            {
                            }
                            dialog.cancel();
                        }
                    });
            builder.show();
        }
        else if(Learnstatus == 2)
        {
            new AlertDialog.Builder(SearchDeviceActivity.this)
                    .setMessage(SearchDeviceActivity.this.getString(R.string.studying))
                    .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent();
                            intent.setClass(SearchDeviceActivity.this, SettingLoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .show();
        }
        else
        {
            new AlertDialog.Builder(SearchDeviceActivity.this)
                    .setTitle("ERROR")
                    .setMessage(message + "\n" + SearchDeviceActivity.this.getString(R.string.msg1))
                    .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent();
                            intent.setClass(SearchDeviceActivity.this, SettingLoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .show();
        }
        */
        btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    btn.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
                    btn.setBackgroundDrawable(btn.getBackground());
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                    btn.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
                    btn.setBackgroundDrawable(btn.getBackground());
                }
                return false;
            }
        });

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = Constants.IP+"cgi-bin/spi_learning?enable=0";
                        HttpURLConnection httpConn = null;
                        try
                        {
                            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                            httpConn.setRequestMethod("GET");
                            httpConn.setDoOutput(true);// 是否輸入參數
                            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                            String str = reader.readLine();
                            message = str;
                            if(!str.equals("Success"))
                            {
                                new AlertDialog.Builder(SearchDeviceActivity.this)
                                        .setTitle("ERROR")
                                        .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Intent intent = new Intent();
                                                intent.setClass(SearchDeviceActivity.this, SettingLearningActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        })
                                        .show();
                            }
                            else
                            {
                                Intent intent = new Intent();
                                intent.setClass(SearchDeviceActivity.this, SettingLearningActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        catch (Exception e)
                        {

                        }
                    }
                }
        );
        text1.setText(R.string.search);
        text2.setText("....");
        text2.startAnimation(alphaAnimation);
        final Button Back = (Button) findViewById(R.id.back);
        Back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = Constants.IP+"cgi-bin/spi_learning?enable=0";
                        HttpURLConnection httpConn = null;
                        try
                        {
                            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                            httpConn.setRequestMethod("GET");
                            httpConn.setDoOutput(true);// 是否輸入參數
                            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                            String str = reader.readLine();
                            message = str;
                            if(!str.equals("Success"))
                            {
                                new AlertDialog.Builder(SearchDeviceActivity.this)
                                        .setTitle("ERROR")
                                        .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                        {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Intent intent = new Intent();
                                                intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        })
                                        .show();
                            }
                            else
                            {
                                Intent intent = new Intent();
                                intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        catch (Exception e)
                        {

                        }
                    }
                }
        );
        Back.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Back.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED2));
                    Back.setBackgroundDrawable(Back.getBackground());
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                    Back.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED2));
                    Back.setBackgroundDrawable(Back.getBackground());
                }
                return false;
            }
        });
    }
    public void RunLearning()
    {
        String url = Constants.IP+"cgi-bin/spi_learning?enable=1";
        HttpURLConnection httpConn = null;
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String str = reader.readLine();
            message = str;
            if(!str.equals("Success"))
            {
                new AlertDialog.Builder(SearchDeviceActivity.this)
                        .setTitle("ERROR")
                        .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent();
                                intent.setClass(SearchDeviceActivity.this, SettingLearningActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .show();
            }
        }
        catch (Exception e)
        {

        }
    }

    public int CheckLearning()
    {
        String url = Constants.IP+"cgi-bin/spi_status";
        HttpURLConnection httpConn = null;
        String str="";
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            str = reader.readLine();
            if(str.equals("SPI Mode: Normal"))
            {
                return 1;
            }
            else if(str.equals("SPI Mode: Learning"))
            {
                return  2;
            }
            else
            {
                message = str;
                return  3;
            }
        }
        catch (Exception e)
        {
            message = str;
            return  3;
        }
    }

    @Override
    public void onBackPressed(){

        String url = Constants.IP+"cgi-bin/spi_learning?enable=0";
        HttpURLConnection httpConn = null;
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
            String str = reader.readLine();
            message = str;
            if(!str.equals("Success"))
            {
                new AlertDialog.Builder(SearchDeviceActivity.this)
                        .setTitle("ERROR")
                        .setMessage(message + "\n" +   SearchDeviceActivity.this.getString(R.string.msg1))
                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent();
                                intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .show();
            }
            else
            {
                Intent intent = new Intent();
                intent.setClass(SearchDeviceActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        catch (Exception e)
        {

        }
    }
}
