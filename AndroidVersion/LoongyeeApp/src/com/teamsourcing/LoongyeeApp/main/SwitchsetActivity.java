package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.util.Xml;
import com.teamsourcing.LoongyeeApp.model.Device;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/25
 * Time: 上午 2:49
 * To change this template use File | Settings | File Templates.
 */
public class SwitchsetActivity extends Activity  implements View.OnClickListener {
    private Button back;
    private Button switch1;
    private Button switch2;
    private Button switch3;
    private Button switch4;
    private Button switch5;
    private Button switch6;
    private Button switch7;
    private Button switch8;
    private TextView key1;
    private TextView key2;
    private TextView key3;
    private TextView key4;
    private TextView key5;
    private TextView key6;
    private TextView key7;
    private TextView key8;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switchset);
       switch1 = (Button)findViewById(R.id.switch1);
       switch2 = (Button)findViewById(R.id.switch2);
       switch3 = (Button)findViewById(R.id.switch3);
       switch4 = (Button)findViewById(R.id.switch4);
       switch5 = (Button)findViewById(R.id.switch5);
       switch6 = (Button)findViewById(R.id.switch6);
       switch7 = (Button)findViewById(R.id.switch7);
       switch8 = (Button)findViewById(R.id.switch8);
       key1 = (TextView)findViewById(R.id.key1);
       key2 = (TextView)findViewById(R.id.key2);
       key3 = (TextView)findViewById(R.id.key3);
       key4 = (TextView)findViewById(R.id.key4);
       key5 = (TextView)findViewById(R.id.key5);
       key6 = (TextView)findViewById(R.id.key6);
       key7 = (TextView)findViewById(R.id.key7);
       key8 = (TextView)findViewById(R.id.key8);


        /*****************************************test********************************/
//       Device dev = new Device();
//        ArrayList<Device> haveFile = dev.test();
//        if(haveFile != null)
//        {
//            File vSDCard =  Environment.getExternalStorageDirectory();
//            try
//            {
//                BufferedReader reader = new BufferedReader(new FileReader(vSDCard.getParent() + "/" + vSDCard.getName() + "/Device/DeviceNote.txt"));
//                String Line = null;
//                Line = reader.readLine();
//                int Index = 0;
//                for(int i=0; i<haveFile.size();i++)
//                {
//                    int flag = Line.compareTo(haveFile.get(i).getRssi());
//                    if(flag == 0)
//                        {
//                        Index = i;
//                        break;
//                    }
//                }
//                switch1.setBackgroundResource(R.drawable.switchs_ok);
//                switch1.setText("");
//                key1.setText(haveFile.get(Index).getName());
//
//                Line = reader.readLine();
//                for(int i=0; i<haveFile.size();i++)
//                {
//                    int flag = Line.compareTo(haveFile.get(i).getRssi());
//                    if(flag == 0)
//                    {
//                        Index = i;
//                        break;
//                    }
//                }
//                switch2.setBackgroundResource(R.drawable.switchs_ok);
//                switch2.setText("");
//                key2.setText(haveFile.get(Index).getName());
//
//                Line = reader.readLine();
//                for(int i=0; i<haveFile.size();i++)
//                {
//                    int flag = Line.compareTo(haveFile.get(i).getRssi());
//                    if(flag == 0)
//                    {
//                        Index = i;
//                        break;
//                    }
//                }
//                switch3.setBackgroundResource(R.drawable.switchs_ok);
//                switch3.setText("");
//                key3.setText(haveFile.get(Index).getName());
//
//                return;
//            }
//            catch (Exception e)
//            {
//
//            }
//        }
//        else
//        {
//            return;
//        }
        /**********************************************************************************/

             switch1.setBackgroundResource(R.drawable.switchs_ok);
             switch1.setText("");
             key1.setText("Gordon's House");



            switch2.setBackgroundResource(R.drawable.switchs_ok);
            switch2.setText("");
            key2.setText("Second Floor");



            switch3.setBackgroundResource(R.drawable.switchs_ok);
            switch3.setText("");
            key3.setText("Basement");


            switch4.setVisibility(View.GONE);


//        if  (subpair5 .equals("FFFFFF")){
            switch5.setVisibility(View.GONE);
//        } else{
//            switch5.setBackgroundResource(R.drawable.switchs_ok);
//            switch5.setText("");
//            if (subcounts5 .equals("8")){
//                key5.setText("Gordon's House");
//            } else if (subcounts5 .equals("2")){
//                key5.setText("Second Floor");
//            } else if (subcounts5 .equals("1")){
//                key5.setText("Basement");
//            }
//        }

//        if  (subpair6 .equals("FFFFFF")){
            switch6.setVisibility(View.GONE);
//        } else{
//            switch6.setBackgroundResource(R.drawable.switchs_ok);
//            switch6.setText("");
//            if (subcounts6 .equals("8")){
//                key6.setText("Gordon's House");
//            } else if (subcounts6 .equals("2")){
//                key6.setText("Second Floor");
//            } else if (subcounts6 .equals("1")){
//                key6.setText("Basement");
//            }
//        }

//        if  (subpair7 .equals("FFFFFF")){
            switch7.setVisibility(View.GONE);
//        } else{
//            switch7.setBackgroundResource(R.drawable.switchs_ok);
//            switch7.setText("");
//            if (subcounts7 .equals("8")){
//                key7.setText("Gordon's House");
//            } else if (subcounts7 .equals("2")){
//                key7.setText("Second Floor");
//            } else if (subcounts7 .equals("1")){
//                key7.setText("Basement");
//            }
//        }
//        if  (subpair8 .equals("FFFFFF")){
            switch8.setVisibility(View.GONE);
//        } else{
//            switch8.setBackgroundResource(R.drawable.switchs_ok);
//            switch8.setText("");
//            if (subcounts8 .equals("8")){
//                key8.setText("Gordon's House");
//            } else if (subcounts8 .equals("2")){
//                key8.setText("Second Floor");
//            } else if (subcounts8 .equals("1")){
//                key8.setText("Basement");
//            }
//        }
   }
    @Override
    public void onClick(View view) {
//        socketservice socketservice = new socketservice("VT220","#");	//Windows,用VT220,否则会乱码
//        socketservice.login("10.10.10.254", 23, "admin", "admin");
//        String rs = socketservice.sendCommand("gtcmd_light.sh getlight all");
//        try {
//            rs = new String(rs.getBytes("ISO-8859-1"),"GBK");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        socketservice.distinct();
//
//        String subrs1 = (rs.split("remote_code1")[1]).trim();
//        String subpair1 = subrs1.substring(1,7);
//        String subrs2 = (rs.split("remote_code2")[1]).trim();
//        String subpair2 = subrs2.substring(1,7);
//        String subrs3 = (rs.split("remote_code3")[1]).trim();
//        String subpair3 = subrs3.substring(1,7);
//        String subrs4 = (rs.split("remote_code4")[1]).trim();
//        String subpair4 = subrs4.substring(1,7);
//        String subrs5 = (rs.split("remote_code5")[1]).trim();
//        String subpair5 = subrs5.substring(1,7);
//        String subrs6 = (rs.split("remote_code6")[1]).trim();
//        String subpair6 = subrs6.substring(1,7);
//        String subrs7 = (rs.split("remote_code7")[1]).trim();
//        String subpair7 = subrs7.substring(1,7);
//        String subrs8 = (rs.split("remote_code8")[1]).trim();
//        String subpair8 = subrs8.substring(1,7);
//
//        String keycounts1 = (rs.split("key_id1")[1]).trim();
//        String subcounts1 = keycounts1.substring(2,3);
//        String keycounts2 = (rs.split("key_id2")[1]).trim();
//        String subcounts2 = keycounts2.substring(2,3);
//        String keycounts3 = (rs.split("key_id3")[1]).trim();
//        String subcounts3 = keycounts3.substring(2,3);
//        String keycounts4 = (rs.split("key_id4")[1]).trim();
//        String subcounts4 = keycounts4.substring(2,3);
//        String keycounts5 = (rs.split("key_id5")[1]).trim();
//        String subcounts5 = keycounts5.substring(2,3);
//        String keycounts6 = (rs.split("key_id6")[1]).trim();
//        String subcounts6 = keycounts6.substring(2,3);
//        String keycounts7 = (rs.split("key_id7")[1]).trim();
//        String subcounts7 = keycounts7.substring(2,3);
//        String keycounts8 = (rs.split("key_id8")[1]).trim();
//        String subcounts8 = keycounts8.substring(2,3);


        if (view.getId() == R.id.back) {
            Intent intent = new Intent();
            intent.setClass(SwitchsetActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.switch1) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key","8");
                bundle.putString("ID","");
                bundle.putString("status","1");
                intent.putExtras(bundle);
//                if (subcounts1 .equals("8")){
             intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//                } else if(subcounts1 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//                } else if(subcounts1 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//                }
                startActivity(intent);
                finish();
        } else if (view.getId() == R.id.switch2) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key","2");
            bundle.putString("ID","");
            bundle.putString("status","2");
            intent.putExtras(bundle);
//            if (subcounts2 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts2 .equals("2")) {
            intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts2 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
            startActivity(intent);
            finish();
      }  else if (view.getId() == R.id.switch3) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key","1");
            bundle.putString("ID","");
            bundle.putString("status","3");
            intent.putExtras(bundle);
            intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
            startActivity(intent);
            finish();
//        } else if (view.getId() == R.id.switch4) {
//            Intent intent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString("key",subcounts4);
//            bundle.putString("ID",subpair4);
//            bundle.putString("status","4");
//            intent.putExtras(bundle);
//            if (subcounts4 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts4 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts4 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
//            startActivity(intent);
//            finish();
//        } else if (view.getId() == R.id.switch5) {
//            Intent intent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString("key",subcounts5);
//            bundle.putString("ID",subpair5);
//            bundle.putString("status","5");
//            intent.putExtras(bundle);
//            if (subcounts5 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts5 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts5 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
//            startActivity(intent);
//            finish();
//        }  else if (view.getId() == R.id.switch6) {
//            Intent intent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString("key",subcounts6);
//            bundle.putString("ID",subpair6);
//            bundle.putString("status","6");
//            intent.putExtras(bundle);
//            if (subcounts6 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts6 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts6 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
//            startActivity(intent);
//            finish();
//        } else if (view.getId() == R.id.switch7) {
//            Intent intent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString("key",subcounts7);
//            bundle.putString("ID",subpair7);
//            bundle.putString("status","7");
//            intent.putExtras(bundle);
//            if (subcounts7 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts7 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts7 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
//            startActivity(intent);
//            finish();
//
//        } else if (view.getId() == R.id.switch8) {
//            Intent intent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString("key",subcounts8);
//            bundle.putString("ID",subpair8);
//            bundle.putString("status","8");
//            intent.putExtras(bundle);
//            if (subcounts8 .equals("8")){
//                intent.setClass(SwitchsetActivity.this, SubSwitch8keyActivity.class);
//            } else if(subcounts8 .equals("2")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch2KeyActivity.class);
//            } else if(subcounts8 .equals("1")) {
//                intent.setClass(SwitchsetActivity.this, SubSwitch1KeyActivity.class);
//            }
//            startActivity(intent);
//            finish();
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
