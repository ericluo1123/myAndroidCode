package com.teamsourcing.LoongyeeApp.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.app.ProgressDialog;
import android.media.SoundPool;
import android.media.AudioManager;

//import java.util.logging.Handler;
import com.teamsourcing.LoongyeeApp.model.Device;

/**
 * Created by teamsourcing on 2014/4/12.
 */
public class ExpandableListAdapter extends  BaseExpandableListAdapter {
    private Context _context;
//    private HashMap<String,List<Button>> _Listbtn =new HashMap<String,List<Button>>();
    private ArrayList<Device> device;
    private ArrayList<String> _listStatus;
  //  private HashMap<String, List<Boolean>> _listStatus;
    private HashMap<String, List<String>> _listDataChild;
    private HashMap<String, List<String>> _listKey;
    private String message="";
    private SoundPool sp;
    int music;

    public ExpandableListAdapter(Context context, HashMap<String, List<String>> listChildData,
                                 HashMap<String, List<String>> _listKey,ArrayList<String> _listStatus,
                                 ArrayList<Device> device)
    {
        this._context = context;
        this._listDataChild = listChildData;
        this._listKey = _listKey;
        this._listStatus = _listStatus;
       // this._Listbtn = _Listbtn;
        this.device = device;
        sp= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music = sp.load(_context, R.raw.windows_ding, 1);

    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                char c = str.charAt(i);
                if(c != 45){
                    return false;
                }
            }
        }
        return true;
    }
    private String convertString(String status)
    {
        String str="";
        char cl = status.charAt(0), cr = status.charAt(1);
        String left = Integer.toBinaryString( Integer.parseInt(status.substring(0,1)) );
        String right = Integer.toBinaryString( Integer.parseInt(status.substring(1,status.length())) );
        if(cl >= 48 && cl <= 55 && cr >= 48 && cr <= 55)
        {
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
            str = null;
        }
        return str;
    }

    public int CheckLearning()
    {
        String url = Constants.IP+"cgi-bin/spi_status";
        HttpURLConnection httpConn = null;
        String str=_context.getString(R.string.msg2);
        try
        {
            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setDoOutput(true);// 是否輸入參數
            httpConn.setConnectTimeout(10000);
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
    @Override
     public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this.device.get(groupPosition).getLoopCode())
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText;// = (String) getChild(groupPosition, childPosition);
        final int posIndex = groupPosition;
        final Button ChildClick;
        ImageView timeClick;

        if(childPosition == 0)//if(childPosition == 0 && !device.get(posIndex).getKeyId().equals("01"))
        {

            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_close_all, null);

            convertView.setBackgroundColor(Color.RED);
            TextView txtListChild = (TextView) convertView.findViewById(R.id.textview_close_all);
            ImageView img = (ImageView) convertView.findViewById(R.id.imageview_rssi);
            String rssi = device.get(groupPosition).getRssi();
            int num = -1;
            if(isNumeric(rssi))
            {
                num = Integer.parseInt(rssi);
                if( (num > -85)&&(num<=-75) )
                {
                    img.setImageResource(R.drawable.rssi02);
                }
                else if((num > -75)&&(num<=-65))
                {
                    img.setImageResource(R.drawable.rssi03);
                }
                else if((num > -65)&&(num<=-55))
                {
                    img.setImageResource(R.drawable.rssi04);
                }
                else if(num > -55)
                {
                    img.setImageResource(R.drawable.rssi05);
                }
                else
                {
                    img.setImageResource(R.drawable.rssi01);
                }
            }
            final String Rssi_str = "Rssi=" +  Integer.toString(num);
            img.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(view.getContext(),Rssi_str , Toast.LENGTH_LONG).show();
                        }
                 }
            );

            txtListChild.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sp.play(music,1,1,0,0,1);

//                            String LoopCode = device.get(posIndex).getLoopCode();
//                            String KeyID = device.get(posIndex).getKeyId();
//                            String loopcode = String.valueOf(LoopCode.substring(0,1) +LoopCode.substring(1,2)+ "," + LoopCode.substring(2,3)
//                                    + LoopCode.substring(3,4) + "," + LoopCode.substring(4,5) + LoopCode.substring(5,LoopCode.length()));
//                            String url = Constants.IP +"cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00," + loopcode
//                                    + ",00,00,00,00,00,"+KeyID+",0D";
//                            HttpURLConnection httpConn = null;
//                            try
//                            {
//                                httpConn = (HttpURLConnection) (new URL(url)).openConnection();
//                                httpConn.setRequestMethod("GET");
//                                httpConn.setDoOutput(true);// 是否輸入參數
//                                BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
//                                String str = reader.readLine();
//                                message = str;
//                                //Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();
//                                String[] sp = str.split(",");
//                                if(convertString(sp[16]) != null)
//                                {
//                                    _listStatus.set(posIndex, convertString(sp[16]));
//                                }
//                                else
//                                {
//                                    //Toast.makeText(view.getContext(), "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
//                                    new AlertDialog.Builder(_context)
//                                            .setTitle("ERROR")
//                                            .setMessage(message + "\n" + _context.getString(R.string.msg1) )
//                                            .setPositiveButton(R.string.alert_ok, null)
//                                            .show();
//                                }
//                                httpConn.disconnect();
//                                notifyDataSetChanged();
//
//                            }
//                            catch (Exception e)
//                            {
//                                //Toast.makeText(view.getContext(), "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
//                                new AlertDialog.Builder(_context)
//                                        .setTitle("ERROR")
//                                        .setMessage(message + "\n" + _context.getString(R.string.msg1))
//                                        .setPositiveButton(R.string.alert_ok, null)
//                                        .show();
//                            }
                            final Handler mHandler = new Handler() {
                                @Override
                                public void handleMessage(Message msg) {
                                    if(msg.what == 1) {
                                        new AlertDialog.Builder(_context)
                                                .setTitle("ERROR")
                                                //.setMessage(_context.getString(R.string.longdist))
                                                .setMessage(message + "\n"+ _context.getString(R.string.msg1))
                                                .setPositiveButton(R.string.alert_ok, null)
                                                .show();
                                    }
                                    notifyDataSetChanged();
                                    super.handleMessage(msg);
                                }
                            };

                            final ProgressDialog myPd_ring=ProgressDialog.show(_context, "",_context.getString(R.string.wait), true);
                            //myPd_ring.setCancelable(true);
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    //int check =  CheckLearning();
                                    //if(check == 3 || check == 4)
                                    //{
                                     //   myPd_ring.dismiss();
                                    //    Message msg = mHandler.obtainMessage();
                                    //    msg.what = 1;
                                   //     msg.sendToTarget();
                                   // }
                                   // else
                                  //  {
                                   // String Key = _listKey.get( device.get(posIndex).getLoopCode()).get(childPosition-1);
                                        String LoopCode = device.get(posIndex).getLoopCode();
                                        String KeyID = device.get(posIndex).getKeyId();

                                        String loopcode = String.valueOf(LoopCode.substring(0,1) +LoopCode.substring(1,2)+ "," + LoopCode.substring(2,3)
                                            + LoopCode.substring(3,4) + "," + LoopCode.substring(4,5) + LoopCode.substring(5,LoopCode.length()));
                                        String url = Constants.IP +"cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00," + loopcode
                                        + ",00,00,00,00,00,"+KeyID+",0D";
                                        HttpURLConnection httpConn = null;
                                        try
                                        {
                                            httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                            httpConn.setRequestMethod("GET");
                                            httpConn.setDoOutput(true);// 是否輸入參數
                                            httpConn.setConnectTimeout(10000);
                                            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));

                                            String r = reader.readLine();
                                            message = r;
                                        //Toast.makeText(view.getContext(), r, Toast.LENGTH_LONG).show();
                                            String[] sp = r.split(",");
                                            Message msg = mHandler.obtainMessage();

                                            myPd_ring.dismiss();
                                            if(convertString(sp[16]) != null)
                                            {
                                                _listStatus.set(posIndex, convertString(sp[16]));
                                            }
                                            else
                                            {
                                                msg.what = 1;
                                                msg.sendToTarget();
                                            }
                                            httpConn.disconnect();

                                            msg.what = 0;
                                            msg.sendToTarget();
                                        }catch(Exception e){
                                            myPd_ring.dismiss();

                                            Message msg = mHandler.obtainMessage();
                                            msg.what = 1;
                                            msg.sendToTarget();
                                        }
                                   // }

                                }
                            }).start();
                    }
               });
        }
        else
        {

            final int childpos;
//            if(!device.get(posIndex).getKeyId().equals("01"))
//            {
//                childpos = childPosition-1;
//            }
//            else
//            {
//                childpos = childPosition;
//            }
            childpos = childPosition-1;
            childText = (String) getChild(groupPosition, childpos);
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child, null);

            TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
            ChildClick = (Button)convertView.findViewById(R.id.button_switch);
            ChildClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    sp.play(music,1,1,0,0,1);

                    final Handler mHandler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            if(msg.what == 1) {
                                new AlertDialog.Builder(_context)
                                        .setTitle("ERROR")
                                        //.setMessage(_context.getString(R.string.longdist))
                                        .setMessage(message + "\n"+ _context.getString(R.string.msg1))
                                        .setPositiveButton(R.string.alert_ok, null)
                                        .show();
                            }
                            notifyDataSetChanged();
                            super.handleMessage(msg);
                        }
                    };
                    final Handler mHandler2 = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            if(msg.what == 1) {
                                new AlertDialog.Builder(_context)
                                        .setMessage(message + "\n"+ _context.getString(R.string.msg5))
                                        .setPositiveButton(R.string.alert_ok, null)
                                        .show();
                            }
                            notifyDataSetChanged();
                            super.handleMessage(msg);
                        }
                    };


                    final ProgressDialog myPd_ring=ProgressDialog.show(_context, "", _context.getString(R.string.wait), true);
                    //myPd_ring.setCancelable(true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int check =  CheckLearning();
                            if(check == 3)
                            {
                                   myPd_ring.dismiss();
                                   Message msg = mHandler2.obtainMessage();
                                   msg.what = 1;
                                   msg.sendToTarget();
                            }
                            else if(check == 4)
                            {
                                myPd_ring.dismiss();
                                Message msg = mHandler.obtainMessage();
                                msg.what = 1;
                                msg.sendToTarget();
                            }
                            else
                            {
                                String Key = _listKey.get( device.get(posIndex).getLoopCode()).get(childpos);
                                String LoopCode = device.get(posIndex).getLoopCode();
                                String KeyID = device.get(posIndex).getKeyId();

                                String loopcode = String.valueOf(LoopCode.substring(0,1) +LoopCode.substring(1,2)+ "," + LoopCode.substring(2,3)
                                    + LoopCode.substring(3,4) + "," + LoopCode.substring(4,5) + LoopCode.substring(5,LoopCode.length()));
                                String url = Constants.IP + "cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00," + loopcode
                                    + ","+Key+",00,00,00,00,"+KeyID+",0D";
                                HttpURLConnection httpConn = null;
                                try
                                {
                                    httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                    httpConn.setRequestMethod("GET");
                                    httpConn.setDoOutput(true);// 是否輸入參數
                                    httpConn.setConnectTimeout(10000);
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                //ChildClick.setBackgroundResource(R.drawable.turnon);
                                //notifyDataSetChanged();

                                    String r = reader.readLine();
                                    message = r;
                                //Toast.makeText(view.getContext(), r, Toast.LENGTH_LONG).show();
                                    String[] sp = r.split(",");
                                    Message msg = mHandler.obtainMessage();

                                    myPd_ring.dismiss();
                                    if(convertString(sp[16]) != null)
                                    {
                                        _listStatus.set(posIndex, convertString(sp[16]));
                                    }
                                    else
                                    {
                                    //Toast.makeText(view.getContext(), "出現錯誤碼請聯絡產商", Toast.LENGTH_SHORT).show();
//                                    new AlertDialog.Builder(_context)
//                                            .setTitle("ERROR")
//                                            .setMessage(message + "\n"+ _context.getString(R.string.msg1))
//                                            .setPositiveButton(R.string.alert_ok, null)
//                                            .show();
                                        msg.what = 1;
                                        msg.sendToTarget();
                                    }
                                    httpConn.disconnect();

                                    msg.what = 0;
                                    msg.sendToTarget();
                                //notifyDataSetChanged();
                                }catch(Exception e){
                                    myPd_ring.dismiss();

                                    Message msg = mHandler.obtainMessage();
                                    msg.what = 1;
                                    msg.sendToTarget();
//                                new AlertDialog.Builder(_context)
//                                        .setTitle("ERROR")
//                                        .setMessage(message + "\n"+ _context.getString(R.string.msg1))
//                                        .setPositiveButton(R.string.alert_ok, null)
//                                        .show();
                                }
                            }

                        }
                    }).start();
                }
            });


            timeClick = (ImageView)convertView.findViewById(R.id.imageview_time);

            SharedPreferences images = _context.getSharedPreferences(Constants.IMAGES, 0);
            String pic = images.getString(device.get(posIndex).getLoopCode() + String.valueOf(childpos), "");
            if(pic != "")
            {
                if(pic.equals("CODE_PHOTO_PIC")){
                    String img = images.getString("IMAGE_DATA" + device.get(posIndex).getLoopCode() + String.valueOf(childpos), "");
                    Bitmap bmp = SettingLearningActivity.StringToBitMap(img);
                    BitmapDrawable bd = new BitmapDrawable(_context.getResources(),bmp);
                    Drawable drawable = (Drawable)bd;
                    timeClick.setImageDrawable(drawable);
                }
                else if(pic.equals("CODE_GALLERY")){
                    String img = images.getString("IMAGE_DATA" + device.get(posIndex).getLoopCode() + String.valueOf(childpos), "");
                    Uri uri = Uri.parse(img);
                    ContentResolver cr = _context.getContentResolver();
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                        BitmapDrawable bd = new BitmapDrawable(_context.getResources(),bitmap);
                        Drawable drawable = (Drawable)bd;
                        timeClick.setImageDrawable(drawable);

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else {
                    timeClick.setImageResource(Integer.parseInt(pic));
                }
               // timeClick.setImageResource(Integer.parseInt(pic));
            }
            timeClick.setOnLongClickListener(
                    new View.OnLongClickListener() {
                        public boolean onLongClick(View arg0) {

                            final Handler mHandler = new Handler() {
                                @Override
                                public void handleMessage(Message msg) {
                                    if(msg.what == 1) {
                                        new AlertDialog.Builder(_context)
                                                .setTitle("ERROR")
                                                        //.setMessage(_context.getString(R.string.longdist))
                                                .setMessage(message + "\n"+ _context.getString(R.string.msg1))
                                                .setPositiveButton(R.string.alert_ok, null)
                                                .show();
                                    }
                                    notifyDataSetChanged();
                                    super.handleMessage(msg);
                                }
                            };

                            final CharSequence[] items = {
                                    "5 min", "10 min", "15 min", "20 min", "25 min"
                            };
                            AlertDialog.Builder builder = new AlertDialog.Builder(_context);
                            builder.setTitle("Please select a regular time");
                            builder.setItems(items, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int item) {
                                    String time=null;
                                    if(item == 0)
                                    {
                                        time = "05";
                                    }
                                    else
                                    {
                                        time = String.valueOf((item + 1)*5);
                                    }
                                    String Key = _listKey.get( device.get(posIndex).getLoopCode()).get(childpos);
                                    String LoopCode = device.get(posIndex).getLoopCode();
                                    String KeyID = device.get(posIndex).getKeyId();

                                    String loopcode = String.valueOf(LoopCode.substring(0,1) +LoopCode.substring(1,2)+ "," + LoopCode.substring(2,3)
                                            + LoopCode.substring(3,4) + "," + LoopCode.substring(4,5) + LoopCode.substring(5,LoopCode.length()));
                                    String url = Constants.IP + "cgi-bin/spi_send?data=15,00,02,00,00,00,00,00,00,00,00,00,00," + loopcode
                                            + ","+Key+",80,"+ time +",00,00,"+KeyID+",0D";
                                    HttpURLConnection httpConn = null;
                                    try
                                    {
                                        httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                        httpConn.setRequestMethod("GET");
                                        httpConn.setDoOutput(true);// 是否輸入參數
                                        httpConn.setConnectTimeout(10000);
                                        BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));

                                        String r = reader.readLine();
                                        message = r;
                                        String[] sp = r.split(",");
                                        Message msg = mHandler.obtainMessage();

                                        if(convertString(sp[16]) != null)
                                        {
                                            _listStatus.set(posIndex, convertString(sp[16]));
                                        }
                                        else
                                        {
                                            msg.what = 1;
                                            msg.sendToTarget();
                                        }

                                        httpConn.disconnect();

                                        msg.what = 0;
                                        msg.sendToTarget();

                                    }
                                    catch (Exception e)
                                    {
                                        Message msg = mHandler.obtainMessage();
                                        msg.what = 1;
                                        msg.sendToTarget();
                                    }
                                }
                            });
                            DialogInterface.OnClickListener CancelClick = new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int which) {
                            }
                            };
                            builder.setNegativeButton("Cancel", CancelClick);
                            AlertDialog alert = builder.create();
                            alert.show();
                            return true;
                        }
                    }
           );

            String str = _listStatus.get(groupPosition);
            int pos;// = str.length()-childPosition;
            pos = str.length()-childPosition;
            if(str.substring(pos, pos+1).equals("1"))
            {
                ChildClick.setBackgroundResource(R.drawable.turnon);
            }
            else
            {
                ChildClick.setBackgroundResource(R.drawable.turnoff);
            }
            txtListChild.setText(childText);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        if(!device.get(groupPosition).getKeyId().equals("01"))
//        {
//            return this._listDataChild.get(this.device.get(groupPosition).getLoopCode()).size() + 1;
//        }
//        else
//        {
//            return this._listDataChild.get(this.device.get(groupPosition).getLoopCode()).size();
//        }
        return this._listDataChild.get(this.device.get(groupPosition).getLoopCode()).size() + 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        String groupName = device.get(groupPosition).getGoupName();
        if(groupName.equals(""))
        {
            groupName = device.get(groupPosition).getLoopCode();
        }
        return groupName;
    }

    @Override
    public int getGroupCount() {
        return this.device.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
       // if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group, null);
       // }

       TextView lblListHeader = (TextView) convertView
               .findViewById(R.id.lblListHeader);
      lblListHeader.setTypeface(null, Typeface.BOLD);
       lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
