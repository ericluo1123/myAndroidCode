package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.widget.Button;
import android.os.AsyncTask;
import android.widget.ImageButton;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import com.teamsourcing.LoongyeeApp.model.Device;
/**
 * Created by teamsourcing on 2014/4/12.
 */
public class ExpandablelistSwitchActivity extends Activity {

    private Button Edit;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    HashMap<String, List<String>> detail = new HashMap<String, List<String>>();
    HashMap<String, List<String>> itemkeyID = new HashMap<String, List<String>>();
    ArrayList<String> itemStatus = new ArrayList<String>();
    ArrayList<Device> dataArray;
    String message="", message2="";
    String itemNo="";

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
        setContentView(R.layout.expandablelist_switch);
        expListView = (ExpandableListView) findViewById(R.id.expandableListView_switch);
        LoadAsyncTask asyncTask = new LoadAsyncTask();
        asyncTask.execute();
        /*
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                detail.clear();
                itemkeyID.clear();
                itemStatus.clear();
                //dataArray.clear();
                Boolean check =  LoadData();
                listAdapter.notifyDataSetChanged();
                return false;
            }
        });
        */
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
            }
        });
    }
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            int responseCode = msg.what;
//            if(responseCode == 1){
//
//            }
//        }
//    };
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
        //dataArray = dev.TestGetData();
        ArrayList<Device> tempArray = new  ArrayList<Device>();
        SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
        //sort.edit().clear().commit();
        SharedPreferences.Editor editor=null;
        if(sort.getAll().size()!=0 && (sort.getAll().size() == dataArray.size()))
        {
            for(int j=0;j<sort.getAll().size();j++)
            {
                String lc = sort.getString(Constants.LOOP_CODE + j, "");
                //dataArray.get(j).setLoopCode(lc);
                for(int n=0;n<dataArray.size();n++)
                {
                    if(lc.equals(dataArray.get(n).getLoopCode()))
                    {
                        tempArray.add(dataArray.get(n));
                        dataArray.remove(n);
//                        Device temp = dataArray.get(j);
//                        dataArray.set(j,dataArray.get(n));
//                        dataArray.set(n,temp);
                        break;
                    }
                }
            }
            dataArray.clear();
            dataArray = tempArray;
        }
        else
        {
            sort.edit().clear().commit();
            editor = sort.edit();
        }

        for(int i=0; i<dataArray.size(); i++)
        {
            if(editor != null)
            {
                editor.putString(Constants.LOOP_CODE + i, dataArray.get(i).getLoopCode()).commit();
            }
            int num = 0;
            message2 = dataArray.get(i).getKeyId();
            if(dataArray.get(i).getKeyId().length() > 2)
            {
                return false;
            }
            if(isNumeric(dataArray.get(i).getKeyId()))
            {
                num = Integer.parseInt(dataArray.get(i).getKeyId());
                if(num==0 || num >8 || num == 5 || num == 6 || num == 7 )
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
            List<String> keyIdArray = new ArrayList<String>();
            if(!dataArray.get(i).getName().equals(""))
            {
                int num2 = num;
                if(num2 == 8)
                {
                    num2 = 6;
                }
                String[] fileName = dataArray.get(i).getName().split(",", -1);
                int n= 0;//, index=1;
                for (String line : fileName)
                {
                    if(n >= num2)
                    {
                        break;
                    }
                    if(!line.equals(""))
                    {
                        nameArray.add(line);
                    }
                    else
                    {
                        nameArray.add("Default" + String.valueOf(n+1));
                    }
                    n++;
                }
                detail.put(dataArray.get(i).getLoopCode(),nameArray );
                for(n=1; n<=num; n++)
                {
                    if((num == 8 && n == 4) ||(num == 8 && n == 8))
                    {

                    }
                    else
                    {
                        keyIdArray.add("0"+String.valueOf(n));
                    }
                }
                itemkeyID.put(dataArray.get(i).getLoopCode(),keyIdArray);
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
                        keyIdArray.add("0"+String.valueOf(n));
                        Index++;
                    }
                }
                detail.put(dataArray.get(i).getLoopCode(),nameArray);
                itemkeyID.put(dataArray.get(i).getLoopCode(),keyIdArray);
                //itembtn.put(dataArray.get(i).getLoopCode(),btnArray);
            }

           // List<Boolean> StatusArray = new ArrayList<Boolean>();
            char cl = status.charAt(0), cr = status.charAt(1);
            String str="";
            if(cl >= 48 && cl <= 55 && cr >= 48 && cr <= 55)
            {
                String left = Integer.toBinaryString( Integer.parseInt(status.substring(0,1)) );
                String right = Integer.toBinaryString( Integer.parseInt(status.substring(1,status.length())) );
                if(left.length()<3)
                {
                   String o="";
                   if(left.length() == 2)
                   {
                      o="0";
                   }
                   else if(left.length() == 1)
                   {
                      o="00";
                   }
                   left = o+left;
                }
                if(right.length()<3)
                {
                  String o="";
                  if(right.length() == 2)
                  {
                     o="0";
                  }
                  else if(right.length() == 1)
                  {
                     o="00";
                  }
                  right = o+right;
                }
                str = left+right;
            }
            else
            {
                //str = "000000";
                return false;
                //Toast.makeText(this, "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
            }
            itemStatus.add(str);
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
                //Toast.makeText(ExpandablelistSwitchActivity.this, "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
               new AlertDialog.Builder(ExpandablelistSwitchActivity.this)
                       .setTitle("ERROR")
                       //.setMessage(ExpandablelistSwitchActivity.this.getString(R.string.longdist))
                       .setMessage("KeyID:"+message2+", Status:" + message + "\n" +  ExpandablelistSwitchActivity.this.getString(R.string.msg1))
                       .setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener()
                       {
                           public void onClick(DialogInterface dialog, int id) {
                               Intent intent = new Intent();
                               intent.setClass(ExpandablelistSwitchActivity.this, MainActivity.class);
                               startActivity(intent);
                               finish();
                           }
                       })
                       .show();

//                Intent intent = new Intent();
//                intent.setClass(ExpandablelistSwitchActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
           }
            else
            {
                Edit = (Button) findViewById(R.id.button_edit);
//                expListView = (ExpandableListView) findViewById(R.id.expandableListView_switch);
//                expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
//                    @Override
//                    public void onGroupExpand(int i) {
//
//                    }
//                });
                expListView.setIndicatorBounds(expListView.getRight()-  expListView.getWidth()/6, expListView.getWidth());
                listAdapter = new ExpandableListAdapter(ExpandablelistSwitchActivity.this, detail, itemkeyID,itemStatus, dataArray);
                expListView.setAdapter(listAdapter);
                Edit.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(ExpandablelistSwitchActivity.this,ListViewSwitchActivity.class);

                        startActivity(intent);
                        finish();
                    }
                });
                Edit.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View arg0, MotionEvent motionEvent) {
                        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                            Edit.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
                            Edit.setBackgroundDrawable(Edit.getBackground());
                        }
                        else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                            Edit.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
                            Edit.setBackgroundDrawable(Edit.getBackground());
                        }
                        return false;
                    }
                });

                final Button Back = (Button) findViewById(R.id.back);
                Back.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent();
                                intent.putExtra("ItemNo", String.valueOf(2));
                                intent.setClass(ExpandablelistSwitchActivity.this, MainActivity.class);

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
        }
    }

    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(2));
        intent.setClass(ExpandablelistSwitchActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
