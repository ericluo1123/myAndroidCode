package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.teamsourcing.LoongyeeApp.model.Device;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.*;

/**
 * Created by teamsourcing on 2014/4/21.
 */
public class SettingLearningAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private ArrayList<Device> device;
    //private ArrayList<String> _listStatus;
    private HashMap<String, List<String>> _listDataChild;
    private HashMap<String, List<String>> _listkeynameDataChild;
    //private HashMap<String, List<String>> _listKey;
    private String message="";
    private PopupWindow	popupWindow = null;
    View editPicView = null;
    private View editView 	= null;
    private static final int CODE_PHOTO_PIC = 1;
    private static final int CODE_GALLERY = 2;

    public SettingLearningAdapter(Context context, HashMap<String, List<String>> listChildData, HashMap<String, List<String>> listkeynameDataChild,
                                 ArrayList<Device> device)
    {
        this._context = context;
        this._listDataChild = listChildData;
        this._listkeynameDataChild = listkeynameDataChild;
        this.device = device;
        //this._listKey = _listKey;
        //this._listStatus = _listStatus;

    }
    public void ResetData(Context context, HashMap<String, List<String>> listChildData,
                                  ArrayList<Device> device)
    {
        this._context = context;
        this._listDataChild = listChildData;
        this.device = device;
    }
    public void setGroupData(int i, String name)
    {
        device.get(i).setGoupName(name);
    }
    public String getGroupNo(int i)
    {
        return device.get(i).getNo();
    }
    public String getGroupData(int i)
    {
        if(device.get(i).getGoupName().equals(""))
        {
            return device.get(i).getLoopCode();
        }
        else
        {
            return device.get(i).getGoupName();
        }
    }
//    private String convertString(String status)
//    {
//        String str="";
//        char cl = status.charAt(0), cr = status.charAt(1);
//        String left = Integer.toBinaryString( Integer.parseInt(status.substring(0,1)) );
//        String right = Integer.toBinaryString( Integer.parseInt(status.substring(1,status.length())) );
//        if(cl >= 48 && cl <= 55 && cr >= 48 && cr <= 55)
//        {
//            if(left.length()<3)
//            {
//                String o="";
//                if(left.length() == 2)
//                {
//                    o="0";
//                }
//                else if(left.length() == 1)
//                {
//                    o="00";
//                }
//                left = o+left;
//            }
//            if(right.length()<3)
//            {
//                String o="";
//                if(right.length() == 2)
//                {
//                    o="0";
//                }
//                else if(right.length() == 1)
//                {
//                    o="00";
//                }
//                right = o+right;
//            }
//            str = left+right;
//        }
//        else
//        {
//            str = null;
//        }
//        return str;
//    }

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

        final String childText;
        final int posIndex = groupPosition;
        final Button ChildClick;
        final  ImageView ImgLongClick;

        childText = (String) getChild(groupPosition, childPosition);
        LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.child, null);

        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        ChildClick = (Button)convertView.findViewById(R.id.button_switch);
        ChildClick.setVisibility(Button.INVISIBLE);
        txtListChild.setText(childText);

        final int groupPos = groupPosition;
        txtListChild.setOnLongClickListener(
        new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(_context);
                builder.setTitle(R.string.edit_name);
                final EditText input = new EditText(_context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                input.setText(_listDataChild.get(device.get(groupPos).getLoopCode()).get(childPosition));
                input.requestFocus();
                builder.setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                String KeyName = "";
                                for(int i=0;i<_listkeynameDataChild.get(device.get(groupPos).getLoopCode()).size();i++)
                                {
                                    if(i==childPosition)
                                    {
                                        if(!input.getText().toString().equals(""))
                                        {
                                            KeyName += input.getText().toString();
                                        }
                                    }
                                    else
                                    {
                                        KeyName += _listkeynameDataChild.get(device.get(groupPos).getLoopCode()).get(i);
                                    }
                                    if(i<_listkeynameDataChild.get(device.get(groupPos).getLoopCode()).size()-1)
                                    {
                                        KeyName += ",";
                                    }
                                }
                                String No = device.get(groupPos).getNo();
                                //String url = Constants.IP+"cgi-bin/uci_set?data=device."+No+".KeyName&value="+KeyName;
                                HttpURLConnection httpConn = null;
                                try
                                {
                                    String url = Constants.IP+"cgi-bin/uci_set?data=device."+No+".KeyName&value="+ URLEncoder.encode(KeyName, "UTF-8");
                                    httpConn = (HttpURLConnection) (new URL(url)).openConnection();
                                    httpConn.setRequestMethod("GET");
                                    httpConn.setDoOutput(true);// 是否輸入參數
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
                                    String str = reader.readLine();
                                    message = str;

                                    if(str.equals("Success"))
                                    {
                                        if(!input.getText().toString().equals(""))
                                        {
                                            _listDataChild.get(device.get(groupPos).getLoopCode()).set(childPosition, input.getText().toString());
                                            _listkeynameDataChild.get(device.get(groupPos).getLoopCode()).set(childPosition, input.getText().toString());
                                        }
                                        else
                                        {
                                            _listDataChild.get(device.get(groupPos).getLoopCode()).set(childPosition, "Default"+String.valueOf(childPosition+1));
                                            _listkeynameDataChild.get(device.get(groupPos).getLoopCode()).set(childPosition, "");
                                        }
                                    }
                                    httpConn.disconnect();
                                    notifyDataSetChanged();
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                );
                builder.setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                builder.setView(input);
                builder.show();
                 return true;
               }
            }
        );
        SharedPreferences images = _context.getSharedPreferences(Constants.IMAGES, 0);

        ImgLongClick = (ImageView) convertView.findViewById(R.id.imageview_time);
        String pic = images.getString(device.get(groupPos).getLoopCode() + String.valueOf(childPosition), "");
        if(pic != "")
        {
            if(pic.equals("CODE_PHOTO_PIC")){
                String img = images.getString("IMAGE_DATA" + device.get(groupPos).getLoopCode() + String.valueOf(childPosition), "");
                Bitmap bmp = SettingLearningActivity.StringToBitMap(img);
                BitmapDrawable bd = new BitmapDrawable(_context.getResources(),bmp);
                Drawable drawable = (Drawable)bd;
                ImgLongClick.setImageDrawable(drawable);
                //bmp.recycle();
            }
            else if(pic.equals("CODE_GALLERY")){
                String img = images.getString("IMAGE_DATA" + device.get(groupPos).getLoopCode() + String.valueOf(childPosition), "");
                Uri uri = Uri.parse(img);
                ContentResolver cr = _context.getContentResolver();
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    BitmapDrawable bd = new BitmapDrawable(_context.getResources(),bitmap);
                    Drawable drawable = (Drawable)bd;
                    ImgLongClick.setImageDrawable(drawable);
                    //bitmap.recycle();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else {
                ImgLongClick.setImageResource(Integer.parseInt(pic));
            }
        }
        ImgLongClick.setOnLongClickListener(
                new View.OnLongClickListener() {

                    public boolean onLongClick(View v) {

                        View editPicView = null;editPicView = View.inflate(_context, R.layout.temperature_humidity_pic_edit, null);
                        LinearLayout ll = (LinearLayout) editPicView.findViewById(R.id.ll_popup);
                        RelativeLayout rl_LocalPic = (RelativeLayout) editPicView.findViewById(R.id.rl_local_pic);
                        RelativeLayout rl_PhotoPic = (RelativeLayout) editPicView.findViewById(R.id.rl_photo_pic);
                        RelativeLayout rl_Gallery = (RelativeLayout) editPicView.findViewById(R.id.rl_gallery);
                        Button pop_cancle = (Button) editPicView.findViewById(R.id.pop_cancel);
                        ll.setBackgroundColor(Color.BLACK);
                        rl_PhotoPic.setVisibility(View.GONE);
                        editPicView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                popupWindow.dismiss();
                            }
                        });
                        rl_Gallery.setOnClickListener(
                                new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        SettingLearningActivity.setLOOPCODE( device.get(groupPos).getLoopCode() + String.valueOf(childPosition));
                                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                                        intent.setType("image/*");
                                        ((Activity) _context).startActivityForResult(Intent.createChooser(intent, ((Activity) _context).getResources().getString(R.string.select_pic)), CODE_GALLERY);

                                        popupWindow.dismiss();
                                    }
                                }
                        );
                        rl_PhotoPic.setOnClickListener(
                                new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        SettingLearningActivity.setLOOPCODE( device.get(groupPos).getLoopCode() + String.valueOf(childPosition));
                                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        ((Activity) _context).startActivityForResult(intent, CODE_PHOTO_PIC);

                                        popupWindow.dismiss();
                                    }
                                }
                        );
                        rl_LocalPic.setOnClickListener(
                                new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent();
                                        intent.putExtra("LOOPCODE", device.get(groupPos).getLoopCode() + String.valueOf(childPosition));
                                        intent.putExtra("GoupNo", String.valueOf(groupPos));
                                        intent.setClass(_context, ListImagesActivity.class);
                                        _context.startActivity(intent);
                                        popupWindow.dismiss();
                                        ((Activity)_context).finish();
                                    }
                                }
                        );
                        pop_cancle.setOnClickListener(
                                new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        popupWindow.dismiss();
                                    }
                                }
                        );

                        editPicView.startAnimation(AnimationUtils.loadAnimation(_context, R.anim.fade_in));
                        LinearLayout ll_popup = (LinearLayout) editPicView.findViewById(R.id.ll_popup);
                        ll_popup.startAnimation(AnimationUtils.loadAnimation(_context, R.anim.push_bottom_in));

                        if(popupWindow==null){
                            popupWindow = new PopupWindow(_context);
                            popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                            popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                            popupWindow.setBackgroundDrawable(new BitmapDrawable());

                            popupWindow.setFocusable(true);
                            popupWindow.setOutsideTouchable(true);
                        }
                        if(editView == null) {
                            editView = View.inflate(_context, R.layout.temperature_humidity_pic_edit, null);
                        }
                        popupWindow.setContentView(editPicView);
                        popupWindow.showAtLocation(editView, Gravity.BOTTOM, 0, -800);
                        popupWindow.update();
//                        Intent intent = new Intent();
//                        intent.putExtra("LOOPCODE", device.get(groupPos).getLoopCode() + String.valueOf(childPosition));
//                        intent.putExtra("GoupNo", String.valueOf(groupPos));
//                        intent.setClass(_context, ListImagesActivity.class);
//                        _context.startActivity(intent);
//                        ((Activity)_context).finish();
                        return true;
                    }
                }
        );

        return convertView;
    }

        @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this.device.get(groupPosition).getLoopCode())
                .size() ;
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
//        convertView.setOnLongClickListener(
//                new View.OnLongClickListener() {
//
//                    public boolean onLongClick(View v) {
//
//                        Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                }
//        );

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
