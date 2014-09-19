package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import com.teamsourcing.LoongyeeApp.model.Device;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;

import java.net.URLEncoder;
import android.widget.*;
import android.view.MotionEvent;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

/**
 * Created by teamsourcing on 2014/4/21.
 */
public class SettingLearningActivity extends Activity {


    Animation alphaAnimation;
    SettingLearningAdapter listAdapter;
    Button btn=null;
    ExpandableListView expListView;
    HashMap<String, List<String>> detail = new HashMap<String, List<String>>();
    HashMap<String, List<String>> keyname = new HashMap<String, List<String>>();
    //HashMap<String, List<String>> itemkeyID = new HashMap<String, List<String>>();
    //ArrayList<String> itemStatus = new ArrayList<String>();
    ArrayList<Device> dataArray;
    String message="", message2="";
    LoadAsyncTask asyncTask = null;
    static String LOOPCODE;


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
        setContentView(R.layout.setting_learning);
        btn = (Button) findViewById(R.id.learn);
        alphaAnimation = new AlphaAnimation(0.2f,1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.RESTART);
//        int Learnstatus =CheckLearning();
//        if(Learnstatus == 2)
//        {
//            btn.setTextColor(Color.WHITE);
//            btn.setBackgroundResource(R.drawable.studying);
//            btn.setText(R.string.studying);
//            btn.startAnimation(alphaAnimation);
//        }

        asyncTask = new LoadAsyncTask();
        asyncTask.execute();
    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public Boolean LoadData()
    {
        Device dev = new Device();
        dataArray = dev.GetData();
        ArrayList<Device> tempArray = new  ArrayList<Device>();

        for(int i=0; i<dataArray.size(); i++)
        {
            int num = 0;
            message2 = dataArray.get(i).getKeyId();
            if(dataArray.get(i).getKeyId().length() > 2)
            {
                return false;
            }
            if(isNumeric(dataArray.get(i).getKeyId()))
            {
                num = Integer.parseInt(dataArray.get(i).getKeyId());
                if(num==0 || num >8 ||  num == 5 || num == 6 || num == 7 )
                {
                    message2 = "KeyID: " + Integer.toString(num);
                    return false;
                }
            }
            else
            {
                return false;
            }
            String status = dataArray.get(i).getStatus();
            message = status;
            if(status.length()>2)
            {
                return false;
            }
            List<String> nameArray = new ArrayList<String>();
            List<String> nameArray2 = new ArrayList<String>();
           // List<String> keyIdArray = new ArrayList<String>();
            if(!dataArray.get(i).getName().equals(""))
            {
                int num2 = num;
                if(num2 == 8)
                {
                    num2 = 6;
                }
                String[] fileName = dataArray.get(i).getName().split(",", -1);
                int n= 0, index=1;
//                int num2 = num;
//                if(num2 >= 8)
//                {
//                    num2 = 6;
//                }
                for (String line : fileName)
                {
                    if(n >= num2)
                    {
                        break;
                    }
                    if(!line.equals(""))
                    {
                        nameArray.add(line);
                        nameArray2.add(line);
                    }
                    else
                    {
                        nameArray.add("Default" + String.valueOf(n+1));
                        nameArray2.add("");
                    }
//                    if((num == 8 && n == 4) ||(num == 8 && n == 8))
//                    {
//
//                    }
//                    else
//                    {
//                        keyIdArray.add("0"+String.valueOf(n));
//                        index++;
//                        //btnArray.add(null);
//                    }
                    n++;
                }
                keyname.put(dataArray.get(i).getLoopCode(),nameArray2 );
                detail.put(dataArray.get(i).getLoopCode(),nameArray );
                //itemkeyID.put(dataArray.get(i).getLoopCode(),keyIdArray);
                //itembtn.put(dataArray.get(i).getLoopCode(),btnArray);
            }
            else
            {
                int Index = 1;
                for(int n=1; n<=num; n++)
                {
                    if((num == 8 && n == 4) ||(num == 8 && n == 8))
                    {

                    }
                    else
                    {

                        //btnArray.add(null);
                        nameArray.add("Default" + String.valueOf(Index));
                        nameArray2.add("");
                        //keyIdArray.add("0"+String.valueOf(n));
                        Index++;
                    }
                }
                detail.put(dataArray.get(i).getLoopCode(),nameArray);
                keyname.put(dataArray.get(i).getLoopCode(),nameArray2 );
                //itemkeyID.put(dataArray.get(i).getLoopCode(),keyIdArray);
                //itembtn.put(dataArray.get(i).getLoopCode(),btnArray);
            }

//            List<Boolean> StatusArray = new ArrayList<Boolean>();
//            char cl = status.charAt(0), cr = status.charAt(1);
//            String str="";
//            if(cl >= 48 && cl <= 55 && cr >= 48 && cr <= 55)
//            {
//                String left = Integer.toBinaryString( Integer.parseInt(status.substring(0,1)) );
//                String right = Integer.toBinaryString( Integer.parseInt(status.substring(1,status.length())) );
//                if(left.length()<3)
//                {
//                    String o="";
//                    if(left.length() == 2)
//                    {
//                        o="0";
//                    }
//                    else if(left.length() == 1)
//                    {
//                        o="00";
//                    }
//                    left = o+left;
//                }
//                if(right.length()<3)
//                {
//                    String o="";
//                    if(right.length() == 2)
//                    {
//                        o="0";
//                    }
//                    else if(right.length() == 1)
//                    {
//                        o="00";
//                    }
//                    right = o+right;
//                }
//                str = left+right;
//            }
//            else
//            {
//                //str = "000000";
//                return false;
//                //Toast.makeText(this, "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
//            }
            //itemStatus.add(str);
        }
        return true;
    }

    public class LoadAsyncTask extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected String doInBackground(Integer... params) {
            Boolean check =  LoadData();
            if(check == true)
            {
                return "TRUE";
            }
            else
            {
                return "FALSE";
            }
        }
        @Override
        protected void onPostExecute(String result) {

            if(result.equals("FALSE"))
            {
                new AlertDialog.Builder(SettingLearningActivity.this)
                        .setTitle("ERROR")
                        //.setMessage(SettingLearningActivity.this.getString(R.string.longdist))
                        .setMessage("KeyID:"+message2+", Status:" + message + "\n" + SettingLearningActivity.this.getString(R.string.msg1))
                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent();
                                intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .show();
            }
            else
            {
                Intent intent=getIntent();
                String value=intent.getStringExtra("GoupNo");
                expListView = (ExpandableListView) findViewById(R.id.expandableListView_switch);
                expListView.setIndicatorBounds(expListView.getRight()-  expListView.getWidth()/6, expListView.getWidth());
                listAdapter = new SettingLearningAdapter(SettingLearningActivity.this, detail, keyname, dataArray);
                expListView.setAdapter(listAdapter);
                if(value!=null)
                {
                    if(!value.equals(""))
                        expListView.expandGroup(Integer.parseInt(value));
                }

                expListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                        int itemType = ExpandableListView.getPackedPositionType(id);
                        if(itemType == ExpandableListView.PACKED_POSITION_TYPE_GROUP)
                        {

                            final int groupPosition = ExpandableListView.getPackedPositionGroup(id);
                            AlertDialog.Builder builder = new AlertDialog.Builder(SettingLearningActivity.this);
                            builder.setTitle(R.string.edit_name);
                            final EditText input = new EditText(SettingLearningActivity.this);
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT);
                            input.setLayoutParams(lp);
                            input.setText(listAdapter.getGroupData(groupPosition));
                            input.requestFocus();

                            builder.setPositiveButton(R.string.ok,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int which) {
                                            // Write your code here to execute after dialog
                                            String No = listAdapter.getGroupNo(groupPosition);

                                            //String url = Constants.IP+"cgi-bin/uci_set?data=device."+No+".GroupName&value="+ input.getText().toString();

                                            //listAdapter.setGroupData(groupPosition, input.getText().toString());
                                            HttpURLConnection httpConn = null;
                                            try
                                            {
                                                String url = Constants.IP+"cgi-bin/uci_set?data=device."+No+".GroupName&value="+ URLEncoder.encode(input.getText().toString(), "UTF-8");
                                                httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                                httpConn.setRequestProperty("Charset", "UTF-8");
                                                httpConn.setRequestMethod("GET");
                                                httpConn.setDoOutput(true);// 是否輸入參數
                                                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                                String str = reader.readLine();
                                                message = str;
                                                //Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();

                                                if(str.equals("Success"))
                                                {
                                                    //_listStatus.set(posIndex, convertString(sp[16]));
                                                    listAdapter.setGroupData(groupPosition, input.getText().toString());
                                                }
                                                httpConn.disconnect();
                                            }
                                            catch (Exception e)
                                            {
                                            }
                                        }
                                    });

                            builder.setNegativeButton(R.string.cancel,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // Write your code here to execute after dialog
                                            dialog.cancel();
                                        }
                                    });
                            builder.setView(input);
                            builder.show();
                        }
                        return true;
                    }
                });

                final Button Back = (Button) findViewById(R.id.back);
                Back.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent();
                                intent.putExtra("ItemNo", String.valueOf(4));
                                intent.setClass(SettingLearningActivity.this, MainActivity.class);

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
                final Button learnBtn = btn;
                learnBtn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
//                                SharedPreferences images = getSharedPreferences(Constants.IMAGES, 0);
//                                sort.edit().clear().commit();
//                                images.edit().clear().commit();
                                int Learnstatus =CheckLearning();
                                if(Learnstatus == 2)
                                {
                                    new AlertDialog.Builder(SettingLearningActivity.this)
                                            .setTitle("Learning")
                                            .setMessage("\n"+SettingLearningActivity.this.getString(R.string.msg3))
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                }
                                            })
                                            .show();
                                }
                                else if(Learnstatus == 3 || Learnstatus == 4)
                                {
                                    new AlertDialog.Builder(SettingLearningActivity.this)
                                            .setTitle("ERROR")
                                            .setMessage("\n"+message)
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                }
                                            })
                                            .show();
                                }
                                else
                                {
//                                    SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
//                                    SharedPreferences images = getSharedPreferences(Constants.IMAGES, 0);
//                                    sort.edit().clear().commit();
//                                    images.edit().clear().commit();
                                    Intent intent = new Intent();
                                    intent.setClass(SettingLearningActivity.this, SearchDeviceActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                        }
                );
                /*
                final Button learnBtn = btn;//(Button) findViewById(R.id.learn);
                learnBtn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

//                                learnBtn.setTextColor(Color.WHITE);
//                                learnBtn.setBackgroundResource(R.drawable.studying);
//                                learnBtn.setText("學習中...");
                                int Learnstatus =CheckLearning();
                                if(Learnstatus==2)
                                {
                                    new AlertDialog.Builder(SettingLearningActivity.this)
                                            .setTitle("Learning")
                                            .setMessage("\n"+R.string.msg3)
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
                                                    SharedPreferences images = getSharedPreferences(Constants.IMAGES, 0);
                                                    sort.edit().clear().commit();
                                                    images.edit().clear().commit();
                                                    dialog.cancel();
                                                }
                                            })
                                            .show();

                                }
                                else if(Learnstatus == 3)
                                {
                                    new AlertDialog.Builder(SettingLearningActivity.this)
                                            .setTitle("ERROR")
                                            .setMessage(message + "\n" +  SettingLearningActivity.this.getString(R.string.msg1))
                                            .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                            {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    Intent intent = new Intent();
                                                    intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            })
                                            .show();
                                }
                                else
                                {
                                    alphaAnimation.setRepeatCount(-1);
                                    learnBtn.startAnimation(alphaAnimation);
                                    learnBtn.setTextColor(Color.WHITE);
                                    learnBtn.setBackgroundResource(R.drawable.studying);
                                    learnBtn.setText(R.string.studying);
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
                                            new AlertDialog.Builder(SettingLearningActivity.this)
                                                .setTitle("ERROR")
                                                .setMessage(message + "\n" +   SettingLearningActivity.this.getString(R.string.msg1))
                                                .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                                {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent();
                                                        intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                })
                                                .show();
                                        }
                                        httpConn.disconnect();
                                        SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
                                        SharedPreferences images = getSharedPreferences(Constants.IMAGES, 0);
                                        sort.edit().clear().commit();
                                        images.edit().clear().commit();

                                    }
                                    catch (Exception e)
                                    {
                                    }
                                }
                            }
                        }
                );
                */

                /*
                final Button refreshBtn = (Button) findViewById(R.id.refresh);
                refreshBtn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                alphaAnimation.setRepeatCount(0);
                                learnBtn.setText(R.string.study);
                                learnBtn.setTextColor(Color.BLACK);
                                learnBtn.setBackgroundResource(R.drawable.study);
                                int Learnstatus =CheckLearning();
                                if(Learnstatus == 2)
                                {
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
                                            new AlertDialog.Builder(SettingLearningActivity.this)
                                                .setTitle("ERROR")
                                                .setMessage(message + "\n" +   SettingLearningActivity.this.getString(R.string.msg1))
                                                .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                                {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent();
                                                        intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                })
                                                .show();
                                        }
                                        else
                                        {
//                                            Intent intent = new Intent();
//                                            intent.setClass(SettingLearningActivity.this, SettingLearningActivity.class);
//                                            startActivity(intent);

//                                            finish();
//                                            Intent intent = new Intent(SettingLearningActivity.this, SettingLearningActivity.class);
//                                            startActivity(intent);
                                            if(LoadData())
                                            {
                                                listAdapter.ResetData(SettingLearningActivity.this, detail, dataArray);
                                                listAdapter.notifyDataSetChanged();
                                            }
                                            else
                                            {
                                                new AlertDialog.Builder(SettingLearningActivity.this)
                                                        .setTitle("ERROR")
                                                        .setMessage("KeyID:"+message2+", Status:" + message + "\n" + SettingLearningActivity.this.getString(R.string.msg1))
                                                        .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                                                        {
                                                            public void onClick(DialogInterface dialog, int id) {
                                                                Intent intent = new Intent();
                                                                intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                                                startActivity(intent);
                                                                finish();
                                                            }
                                                        })
                                                        .show();
                                            }
                                        }
                                        httpConn.disconnect();
                                        //alphaAnimation.setRepeatCount(0);
                                    }
                                    catch (Exception e)
                                    {
                                    }
                                }
                                else
                                {

//                                    alphaAnimation.setRepeatCount(0);
//                                    Intent intent = new Intent();
//                                    intent.setClass(SettingLearningActivity.this, SettingLearningActivity.class);
//                                    startActivity(intent);
//                                    finish();
                                    if(LoadData())
                                    {
                                        listAdapter.ResetData(SettingLearningActivity.this, detail, dataArray);
                                        listAdapter.notifyDataSetChanged();
                                    }
                                    else
                                    {
                                        new AlertDialog.Builder(SettingLearningActivity.this)
                                                .setTitle("ERROR")
                                                .setMessage("KeyID:"+message2+", Status:" + message + "\n" +  SettingLearningActivity.this.getString(R.string.msg1))
                                                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                                                {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        Intent intent = new Intent();
                                                        intent.setClass(SettingLearningActivity.this, MainActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                })
                                                .show();
                                    }
                                }
                            }
                        }
                );
                refreshBtn.setOnTouchListener(
                        new View.OnTouchListener(){
                            @Override
                            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //按下的時候改變背景及顏色
                                    refreshBtn.setBackgroundResource(R.drawable.refresh02);
                                }
                                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //起來的時候恢復背景與顏色
                                    refreshBtn.setBackgroundResource(R.drawable.refresh01);
                                }
                                return false;
                            }
                        }
                );
                */
            }
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
            else if(str.equals("SPI Mode: Busy"))
            {
                message = str;
                return  3;
            }
            else
            {
                message = str;
                return  4;
            }
        }
        catch (Exception e)
        {
            message = str;
            return  4;
        }
    }
    public static void setLOOPCODE(String loopcode){
        LOOPCODE = loopcode;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences images = this.getSharedPreferences(Constants.IMAGES, 0);
        SharedPreferences.Editor editor=images.edit();
        if (resultCode == RESULT_OK) {
            switch(requestCode) {
                case 1: {
                    editor.putString(LOOPCODE, "CODE_PHOTO_PIC");
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    editor.putString("IMAGE_DATA" + LOOPCODE, BitMapToString(bitmap));
                    editor.commit();
                    listAdapter.notifyDataSetChanged();
                    break;
                }
                case 2:{
                    Uri uri = data.getData();
                    editor.putString(LOOPCODE, "CODE_GALLERY");
                    editor.putString("IMAGE_DATA" + LOOPCODE, uri.toString());
                    editor.commit();
                    listAdapter.notifyDataSetChanged();
                    break;
                }
            }
        }
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
    public static Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

        @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(4));
        intent.setClass(SettingLearningActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
