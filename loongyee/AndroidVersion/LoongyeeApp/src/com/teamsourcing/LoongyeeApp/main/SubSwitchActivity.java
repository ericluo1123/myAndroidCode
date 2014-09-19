package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teamsourcing.LoongyeeApp.Properties;
//import com.teamsourcing.LoongyeeApp.telnet.socketservice;
import com.teamsourcing.LoongyeeApp.main.R;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.text.NumberFormat;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/26
 * Time: 下午 1:51
 * To change this template use File | Settings | File Templates.
 */
public class SubSwitchActivity extends Activity implements View.OnClickListener {
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
        switchs.setText("Switch"+SwitchID);
//        socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//        socketservice.login("10.10.10.254", 23, "admin", "admin");
//        String rs = socketservice.sendCommand("gtcmd_light.sh setlight"+" "+SwitchID);

//        try {
//            //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");	//转一下编码
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//        try {
//            rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String subrs = (rs1.split("light_status")[1]).trim();
//        int sublight = Integer.parseInt(subrs.substring(3,5));
//        String light = Integer.toBinaryString(sublight);
//        String lights =  "00000000".substring(0,8 - light.length()) + light;
//        String lightstatus1 = lights.substring(7,8);
//        String lightstatus2 = lights.substring(6,7);
//        String lightstatus3 = lights.substring(5,6);
//        String lightstatus5 = lights.substring(3,4);
//        String lightstatus6 = lights.substring(2,3);
//        String lightstatus7 = lights.substring(1,2);
//        if (lightstatus1 .equals("0")) {
//            subswitchturn1.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn1.setImageResource(R.drawable.turnon);
//        }
//        if (lightstatus2 .equals("0")) {
//            subswitchturn2.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn2.setImageResource(R.drawable.turnon);
//        }
//        if (lightstatus3 .equals("0")) {
//            subswitchturn3.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn3.setImageResource(R.drawable.turnon);
//        }
//        if (lightstatus5 .equals("0")) {
//            subswitchturn5.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn5.setImageResource(R.drawable.turnon);
//        }
//        if (lightstatus6 .equals("0")) {
//            subswitchturn6.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn6.setImageResource(R.drawable.turnon);
//        }
//        if (lightstatus7 .equals("0")) {
//            subswitchturn7.setImageResource(R.drawable.turnoff);
//        }   else {
//            subswitchturn7.setImageResource(R.drawable.turnon);
//        }



    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.setClass(SubSwitchActivity.this, SwitchsetActivity.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.turn_off_all){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 0"+" "+SwitchID+" "+"0");

//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");	//转一下编码
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            //System.out.println(rs);
            subswitchturn1.setImageResource(R.drawable.turnoff);
            subswitchturn2.setImageResource(R.drawable.turnoff);
            subswitchturn3.setImageResource(R.drawable.turnoff);
            //subswitchturn4.setImageResource(R.drawable.turnoff);
            subswitchturn5.setImageResource(R.drawable.turnoff);
            subswitchturn6.setImageResource(R.drawable.turnoff);
            subswitchturn7.setImageResource(R.drawable.turnoff);
            //subswitchturn8.setImageResource(R.drawable.turnoff);
            Properties.lockType1 = 0;
            Properties.lockType2 = 0;
            Properties.lockType3 = 0;
            Properties.lockType5 = 0;
            Properties.lockType6 = 0;
            Properties.lockType7 = 0;
          }else if (view.getId() == R.id.subswitchturn1){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 1"+" "+SwitchID+" "+"0");
//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }

//
            if (Properties.lockType1 == 0) {
                subswitchturn1.setImageResource(R.drawable.turnon);
                Properties.lockType1 = 1;
            }   else {
                subswitchturn1.setImageResource(R.drawable.turnoff);
                Properties.lockType1 = 0;
            }

        }else if (view.getId() == R.id.subswitchturn2){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 2"+" "+SwitchID+" "+"0");
//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }

//            String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//            try {
//                rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//            String subrs = (rs1.split("light_status")[1]).trim();
//            int sublight = Integer.parseInt(subrs.substring(3,5));
//            String light = Integer.toBinaryString(sublight);
//            String lights =  "00000000".substring(0,8 - light.length()) + light;
//            String lightstatus1 = lights.substring(7,8);
//            String lightstatus2 = lights.substring(6,7);
//            String lightstatus3 = lights.substring(5,6);
//            String lightstatus5 = lights.substring(3,4);
//            String lightstatus6 = lights.substring(2,3);
//            String lightstatus7 = lights.substring(1,2);
//            if (lightstatus1 .equals("0")) {
//                subswitchturn1.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn1.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus2 .equals("0")) {
//                subswitchturn2.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn2.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus3 .equals("0")) {
//                subswitchturn3.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn3.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus5 .equals("0")) {
//                subswitchturn5.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn5.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus6 .equals("0")) {
//                subswitchturn6.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn6.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus7 .equals("0")) {
//                subswitchturn7.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn7.setImageResource(R.drawable.turnon);
//            }
            if (Properties.lockType2 == 0) {
                subswitchturn2.setImageResource(R.drawable.turnon);
                Properties.lockType2 = 1;
            }   else {
                subswitchturn2.setImageResource(R.drawable.turnoff);
                Properties.lockType2 = 0;
            }

        }else if (view.getId() == R.id.subswitchturn3){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 3"+" "+SwitchID+" "+"0");
//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
            if (Properties.lockType3 == 0) {
                subswitchturn3.setImageResource(R.drawable.turnon);
                Properties.lockType3 = 1;
            }   else {
                subswitchturn3.setImageResource(R.drawable.turnoff);
                Properties.lockType3 = 0;
            }
        }else if (view.getId() == R.id.subswitchturn5){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 5"+" "+SwitchID+" "+"0");
//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//            try {
//                rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//            String subrs = (rs1.split("light_status")[1]).trim();
//            int sublight = Integer.parseInt(subrs.substring(3,5));
//            String light = Integer.toBinaryString(sublight);
//            String lights =  "00000000".substring(0,8 - light.length()) + light;
//            String lightstatus1 = lights.substring(7,8);
//            String lightstatus2 = lights.substring(6,7);
//            String lightstatus3 = lights.substring(5,6);
//            String lightstatus5 = lights.substring(3,4);
//            String lightstatus6 = lights.substring(2,3);
//            String lightstatus7 = lights.substring(1,2);
//            if (lightstatus1 .equals("0")) {
//                subswitchturn1.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn1.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus2 .equals("0")) {
//                subswitchturn2.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn2.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus3 .equals("0")) {
//                subswitchturn3.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn3.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus5 .equals("0")) {
//                subswitchturn5.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn5.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus6 .equals("0")) {
//                subswitchturn6.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn6.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus7 .equals("0")) {
//                subswitchturn7.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn7.setImageResource(R.drawable.turnon);
//            }

            if (Properties.lockType5 == 0) {
                subswitchturn5.setImageResource(R.drawable.turnon);
                Properties.lockType5 = 1;
            }   else {
                subswitchturn5.setImageResource(R.drawable.turnoff);
                Properties.lockType5 = 0;
            }
        }else if (view.getId() == R.id.subswitchturn6){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
//            socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//            socketservice.login("10.10.10.254", 23, "admin", "admin");
//            String rs = socketservice.sendCommand("gtcmd_light.sh setlight 6"+" "+SwitchID+" "+"0");
//            try {
//                //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//            try {
//                rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//            String subrs = (rs1.split("light_status")[1]).trim();
//            int sublight = Integer.parseInt(subrs.substring(3,5));
//            String light = Integer.toBinaryString(sublight);
//            String lights =  "00000000".substring(0,8 - light.length()) + light;
//            String lightstatus1 = lights.substring(7,8);
//            String lightstatus2 = lights.substring(6,7);
//            String lightstatus3 = lights.substring(5,6);
//            String lightstatus5 = lights.substring(3,4);
//            String lightstatus6 = lights.substring(2,3);
//            String lightstatus7 = lights.substring(1,2);
//            if (lightstatus1 .equals("0")) {
//                subswitchturn1.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn1.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus2 .equals("0")) {
//                subswitchturn2.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn2.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus3 .equals("0")) {
//                subswitchturn3.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn3.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus5 .equals("0")) {
//                subswitchturn5.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn5.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus6 .equals("0")) {
//                subswitchturn6.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn6.setImageResource(R.drawable.turnon);
//            }
//            if (lightstatus7 .equals("0")) {
//                subswitchturn7.setImageResource(R.drawable.turnoff);
//            }   else {
//                subswitchturn7.setImageResource(R.drawable.turnon);
//            }
            if (Properties.lockType6 == 0) {
                subswitchturn6.setImageResource(R.drawable.turnon);
                Properties.lockType6 = 1;
            }   else {
                subswitchturn6.setImageResource(R.drawable.turnoff);
                Properties.lockType6 = 0;
            }

        }else if (view.getId() == R.id.subswitchturn7){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
            //socketservice.login("10.10.10.254", 23, "admin", "admin");
           // String rs = socketservice.sendCommand("gtcmd_light.sh setlight 7"+" "+SwitchID+" "+"0");
//            try {
//             //   rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
            if (Properties.lockType7 == 0) {
                subswitchturn7.setImageResource(R.drawable.turnon);
                Properties.lockType7 = 1;
            }   else {
                subswitchturn7.setImageResource(R.drawable.turnoff);
                Properties.lockType7 = 0;
            }

        } else if (view.getId() == R.id.settime1){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                               // String rs = socketservice.sendCommand("gtcmd_light.sh setlight 1 1"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 1 2"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                //String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    //rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }

//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                               // socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                               // socketservice.login("10.10.10.254", 23, "admin", "admin");
                               // String rs = socketservice.sendCommand("gtcmd_light.sh setlight 1 3"+" "+time);
//                                try {
//                                 //   rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                               // String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                   // rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }

//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }

        } else if (view.getId() == R.id.settime2){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                               // String rs = socketservice.sendCommand("gtcmd_light.sh setlight 2 1"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 2 2"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                               // socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 2 3"+" "+time);
//                                try {
//                                  //  rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }
       } else if (view.getId() == R.id.settime3){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 3 1"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 3 2"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                ///socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 3 3"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }
        }  else if (view.getId() == R.id.settime5){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 5 1"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 5 2"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 5 3"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }
        } else if (view.getId() == R.id.settime6){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 6 1"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 6 2"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                               // socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 6 3"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }
        } else if (view.getId() == R.id.settime7){
            Bundle bundle = this.getIntent().getExtras();
            String SwitchID = bundle.getString("ID");
            if  (SwitchID .equals("1")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
                                //socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
                                //socketservice.login("10.10.10.254", 23, "admin", "admin");
                                //String rs = socketservice.sendCommand("gtcmd_light.sh setlight 7 1"+" "+time);
//                                try {
//                                    //rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();

            }  else if (SwitchID .equals("2")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
//                                socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//                                socketservice.login("10.10.10.254", 23, "admin", "admin");
//                                String rs = socketservice.sendCommand("gtcmd_light.sh setlight 7 2"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            } else if (SwitchID .equals("3")){
                LayoutInflater inflater = this.getLayoutInflater();
                View editView = inflater.inflate(R.layout.settime, null);
                settime = (EditText) editView.findViewById(R.id.settime);
                new AlertDialog.Builder(this)
                        .setTitle(R.string.settime_Info)
                        .setView(editView)
                        .setPositiveButton(R.string.alert_cancel, null)
                        .setNegativeButton(R.string.alert_ok, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int time = Integer.parseInt(settime.getText().toString())*60;
//                                socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//                                socketservice.login("10.10.10.254", 23, "admin", "admin");
                               // String rs = socketservice.sendCommand("gtcmd_light.sh setlight 7 3"+" "+time);
//                                try {
//                                   // rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//                                String rs1 = socketservice.sendCommand("gtcmd_light.sh getlight light_status 1");
//                                try {
//                                    rs1 = new String(rs1.getBytes("ISO-8859-1"),"GBK");
//                                } catch (UnsupportedEncodingException e) {
//                                    e.printStackTrace();
//                                }
//
//                                String subrs = (rs1.split("light_status")[1]).trim();
//                                int sublight = Integer.parseInt(subrs.substring(3,5));
//                                String light = Integer.toBinaryString(sublight);
//                                String lights =  "00000000".substring(0,8 - light.length()) + light;
//                                String lightstatus1 = lights.substring(7,8);
//                                String lightstatus2 = lights.substring(6,7);
//                                String lightstatus3 = lights.substring(5,6);
//                                String lightstatus5 = lights.substring(3,4);
//                                String lightstatus6 = lights.substring(2,3);
//                                String lightstatus7 = lights.substring(1,2);
//                                if (lightstatus1 .equals("0")) {
//                                    subswitchturn1.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn1.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus2 .equals("0")) {
//                                    subswitchturn2.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn2.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus3 .equals("0")) {
//                                    subswitchturn3.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn3.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus5 .equals("0")) {
//                                    subswitchturn5.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn5.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus6 .equals("0")) {
//                                    subswitchturn6.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn6.setImageResource(R.drawable.turnon);
//                                }
//                                if (lightstatus7 .equals("0")) {
//                                    subswitchturn7.setImageResource(R.drawable.turnoff);
//                                }   else {
//                                    subswitchturn7.setImageResource(R.drawable.turnon);
//                                }

                            }
                        }).show();
            }

        }
    }

}
