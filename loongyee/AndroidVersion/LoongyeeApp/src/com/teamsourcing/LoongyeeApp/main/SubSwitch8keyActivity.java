package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.*;
import android.content.Intent;
import android.os.Bundle;
import com.teamsourcing.LoongyeeApp.Properties;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/26
 * Time: 下午 1:51
 * To change this template use File | Settings | File Templates.
 */
public class SubSwitch8keyActivity extends Activity implements View.OnClickListener {
    private Button back;
    private ImageView subswitchturn1;
    private ImageView subswitchturn2;
    private ImageView subswitchturn3;
    private ImageView subswitchturn4;
    private ImageView subswitchturn5;
    private ImageView subswitchturn6;
    private ImageView subswitchturn7;
    private ImageView subswitchturn8;
    private ImageView settime1;
    private ImageView settime2;
    private ImageView settime3;
    private ImageView settime4;
    private ImageView settime5;
    private ImageView settime6;
    private ImageView settime7;
    private ImageView settime8;
    private EditText settime = null;
    private TextView switchs;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subswitch);
        subswitchturn1=(ImageView)findViewById(R.id.subswitchturn1);
        subswitchturn2=(ImageView)findViewById(R.id.subswitchturn2);
        subswitchturn3=(ImageView)findViewById(R.id.subswitchturn3);
       // subswitchturn4=(ImageView)findViewById(R.id.subswitchturn4);
        subswitchturn5=(ImageView)findViewById(R.id.subswitchturn5);
        subswitchturn6=(ImageView)findViewById(R.id.subswitchturn6);
        subswitchturn7=(ImageView)findViewById(R.id.subswitchturn7);
        //subswitchturn8=(ImageView)findViewById(R.id.subswitchturn8);
        settime1= (ImageView)findViewById(R.id.settime1);
        settime2= (ImageView)findViewById(R.id.settime2);
        settime3= (ImageView)findViewById(R.id.settime3);
        //settime4= (ImageView)findViewById(R.id.settime4);
        settime5= (ImageView)findViewById(R.id.settime5);
        settime6= (ImageView)findViewById(R.id.settime6);
        settime7= (ImageView)findViewById(R.id.settime7);
       // settime8= (ImageView)findViewById(R.id.settime8);
        switchs =(TextView)findViewById(R.id.switchs);
        Bundle bundle = this.getIntent().getExtras();
        String SwitchID = bundle.getString("ID");
        String keyID = bundle.getString("key");
        String status = bundle.getString("status");
//        switchs.setText("Switch"+status);
        switchs.setText("Gordon's House");
//        socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//        socketservice.login("10.10.10.254", 23, "admin", "admin");
//        String rs = socketservice.sendCommand("gtcmd_light.sh getlight light_status"+" "+status);
//
//        try {
//            rs = new String(rs.getBytes("ISO-8859-1"),"GBK");	//转一下编码
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        socketservice.distinct();
////        String subrs = (rs.split("light_status"+" "+status)[1]).trim();
//        String subrs = (rs.split("light_status"+" "+status)[1]).trim();
//        String subpair = subrs.substring(0,2);
//        if (subpair .equals("fa")) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage(R.string.msg);
//            builder.setCancelable(false);
//            builder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
//
//                public void onClick(DialogInterface dialog, int id) {
//
//                }
//
//            }) ;
//            AlertDialog alert = builder.create();
//            alert.show();
//
//        } else {
//        int sublight1 = Integer.parseInt(subrs.substring(0,1));
//        int sublight2 = Integer.parseInt(subrs.substring(1,2));
//
//        if (sublight1 == 0)  {
//            subswitchturn5.setImageResource(R.drawable.turnoff);
//            subswitchturn6.setImageResource(R.drawable.turnoff);
//            subswitchturn7.setImageResource(R.drawable.turnoff);
//        } else if (sublight1 == 1){
//            subswitchturn5.setImageResource(R.drawable.turnon);
//            subswitchturn6.setImageResource(R.drawable.turnoff);
//            subswitchturn7.setImageResource(R.drawable.turnoff);
//        } else if (sublight1 == 2){
//            subswitchturn5.setImageResource(R.drawable.turnoff);
//            subswitchturn6.setImageResource(R.drawable.turnon);
//            subswitchturn7.setImageResource(R.drawable.turnoff);
//        } else if (sublight1 == 3){
//            subswitchturn5.setImageResource(R.drawable.turnon);
//            subswitchturn6.setImageResource(R.drawable.turnon);
//            subswitchturn7.setImageResource(R.drawable.turnoff);
//        } else if (sublight1 == 4){
//            subswitchturn5.setImageResource(R.drawable.turnoff);
//            subswitchturn6.setImageResource(R.drawable.turnoff);
//            subswitchturn7.setImageResource(R.drawable.turnon);
//        } else if (sublight1 == 5){
//            subswitchturn5.setImageResource(R.drawable.turnon);
//            subswitchturn6.setImageResource(R.drawable.turnoff);
//            subswitchturn7.setImageResource(R.drawable.turnon);
//        } else if (sublight1 == 6){
//            subswitchturn5.setImageResource(R.drawable.turnoff);
//            subswitchturn6.setImageResource(R.drawable.turnon);
//            subswitchturn7.setImageResource(R.drawable.turnon);
//        } else if (sublight1 == 7){
//            subswitchturn5.setImageResource(R.drawable.turnon);
//            subswitchturn6.setImageResource(R.drawable.turnon);
//            subswitchturn7.setImageResource(R.drawable.turnon);
//        }
//
//        if (sublight2 == 0)  {
//            subswitchturn1.setImageResource(R.drawable.turnoff);
//            subswitchturn2.setImageResource(R.drawable.turnoff);
//            subswitchturn3.setImageResource(R.drawable.turnoff);
//        } else if (sublight2 == 1){
//            subswitchturn1.setImageResource(R.drawable.turnon);
//            subswitchturn2.setImageResource(R.drawable.turnoff);
//            subswitchturn3.setImageResource(R.drawable.turnoff);
//        } else if (sublight2 == 2){
//            subswitchturn1.setImageResource(R.drawable.turnoff);
//            subswitchturn2.setImageResource(R.drawable.turnon);
//            subswitchturn3.setImageResource(R.drawable.turnoff);
//        } else if (sublight2 == 3){
//            subswitchturn1.setImageResource(R.drawable.turnon);
//            subswitchturn2.setImageResource(R.drawable.turnon);
//            subswitchturn3.setImageResource(R.drawable.turnoff);
//        } else if (sublight2 == 4){
//            subswitchturn1.setImageResource(R.drawable.turnoff);
//            subswitchturn2.setImageResource(R.drawable.turnoff);
//            subswitchturn3.setImageResource(R.drawable.turnon);
//        } else if (sublight2 == 5){
//            subswitchturn1.setImageResource(R.drawable.turnon);
//            subswitchturn2.setImageResource(R.drawable.turnoff);
//            subswitchturn3.setImageResource(R.drawable.turnon);
//        } else if (sublight2 == 6){
//            subswitchturn1.setImageResource(R.drawable.turnoff);
//            subswitchturn2.setImageResource(R.drawable.turnon);
//            subswitchturn3.setImageResource(R.drawable.turnon);
//        } else if (sublight2 == 7){
//            subswitchturn1.setImageResource(R.drawable.turnon);
//            subswitchturn2.setImageResource(R.drawable.turnon);
//            subswitchturn3.setImageResource(R.drawable.turnon);
//        }
//        }
    }

    public void chkError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.msgturn);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

            }

        }) ;
        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    public void onClick(View view) {
           Bundle bundle = this.getIntent().getExtras();
           final String SwitchID = bundle.getString("ID");
           final String keyID = bundle.getString("key");
           final String status = bundle.getString("status");
//        socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//        socketservice.login("10.10.10.254", 23, "admin", "admin");
        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.setClass(SubSwitch8keyActivity.this, SwitchsetActivity.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.turn_off_all){
            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,00,00,00,00,00,01,0D";
           /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);


                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }

            subswitchturn1.setImageResource(R.drawable.turnoff);
            subswitchturn2.setImageResource(R.drawable.turnoff);
            subswitchturn3.setImageResource(R.drawable.turnoff);
            //subswitchturn4.setImageResource(R.drawable.turnoff);
            subswitchturn5.setImageResource(R.drawable.turnoff);
            subswitchturn6.setImageResource(R.drawable.turnoff);
            subswitchturn7.setImageResource(R.drawable.turnoff);
            //subswitchturn8.setImageResource(R.drawable.turnoff);
          }else if (view.getId() == R.id.subswitchturn1){
            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,01,00,00,00,00,01,0D";
                        /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }

        }else if (view.getId() == R.id.subswitchturn2){

            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,02,00,00,00,00,01,0D";
                        /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }
        }else if (view.getId() == R.id.subswitchturn3){

            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,03,00,00,00,00,01,0D";
            /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }
        }else if (view.getId() == R.id.subswitchturn5){

            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,05,00,00,00,00,01,0D";
            /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }
        }else if (view.getId() == R.id.subswitchturn6){

            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,06,00,00,00,00,01,0D";
            /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }
        }else if (view.getId() == R.id.subswitchturn7){

            String SyncURL="http://192.168.1.1/cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00,01,00,00,07,00,00,00,00,01,0D";
            /*建立HTTP Get聯機*/
            HttpGet httpRequest = new HttpGet(SyncURL);
            try
            {
          /*發出HTTP request*/
                HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
          /*若狀態碼为200 ok*/
                if(httpResponse.getStatusLine().getStatusCode() == 200)
                {
            /*取出響應字符串*/
                    String strResult = EntityUtils.toString(httpResponse.getEntity());
            /*刪除多餘字符*/
                    strResult = eregi_replace("(/r/n|/r|/n|/n/r)", "", strResult);

                    String subpair = strResult.substring(49,50);
                    if (subpair .equals("e")) {
                        chkError();
                    } else {
                        int sublight1 = Integer.parseInt(strResult.substring(48,49));
                        int sublight2 = Integer.parseInt(strResult.substring(49,50));

                        if (sublight1 == 0)  {
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 1){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 2){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 3){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnoff);
                        } else if (sublight1 == 4){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 5){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnoff);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 6){
                            subswitchturn5.setImageResource(R.drawable.turnoff);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        } else if (sublight1 == 7){
                            subswitchturn5.setImageResource(R.drawable.turnon);
                            subswitchturn6.setImageResource(R.drawable.turnon);
                            subswitchturn7.setImageResource(R.drawable.turnon);
                        }

                        if (sublight2 == 0)  {
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 1){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 2){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 3){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnoff);
                        } else if (sublight2 == 4){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 5){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnoff);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 6){
                            subswitchturn1.setImageResource(R.drawable.turnoff);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        } else if (sublight2 == 7){
                            subswitchturn1.setImageResource(R.drawable.turnon);
                            subswitchturn2.setImageResource(R.drawable.turnon);
                            subswitchturn3.setImageResource(R.drawable.turnon);
                        }
                    }
                }
                else
                {

                }
            }
            catch (ClientProtocolException e)
            {

            }
            catch (IOException e)
            {

            }
            catch (Exception e)
            {

            }
        } else if (view.getId() == R.id.settime1){


        } else if (view.getId() == R.id.settime2){

       } else if (view.getId() == R.id.settime3){

        }  else if (view.getId() == R.id.settime5){

        } else if (view.getId() == R.id.settime6){

        } else if (view.getId() == R.id.settime7){


        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public String eregi_replace(String strFrom, String strTo, String strTarget)
    {
        String strPattern = "(?i)"+strFrom;
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strTarget);
        if(m.find())
        {
            return strTarget.replaceAll(strFrom, strTo);
        }
        else
        {
            return strTarget;
        }
    }

}
