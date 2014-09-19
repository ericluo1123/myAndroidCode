package com.teamsourcing.LoongyeeApp.main;

/**
 * Created by teamsourcing on 2014/4/11.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.AbsListView;
import android.view.Gravity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter implements DropListener{

    private Activity activity;
    //private ArrayList<HashMap<String, String>> data;
    //private static LayoutInflater inflater=null;
    private ArrayList<String> mContent;
    private ArrayList<String> mTitle;

    public ListViewAdapter(Activity a, ArrayList<String> mContent, ArrayList<String> mTitle) {
        activity = a;
        //data=d;
        this.mContent = mContent;
        this.mTitle = mTitle;
        //inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public  ArrayList<String> getSortItem()
    {
        return mContent;
    }

    public int getCount() {
        return mTitle.size();//data.size();
    }

    public Object getItem(int position) {
        //return mContent.get(position);//position;
        return mTitle.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
  //      View vi=convertView;
 //       if(convertView==null)
//            vi = inflater.inflate(R.layout.list_item, null);

//        TextView name = (TextView)vi.findViewById(R.id.name);
//
//        HashMap<String, String> item = new HashMap<String, String>();
//        item = data.get(position);

        //Setting all values in listview
//        name.setText(item.get("name"));
//        return vi;
        TextView myText = null;
        //HashMap<String, String> item = new HashMap<String, String>();
        //item = data.get(position);
//        if (convertView != null) {
//                myText = (TextView)convertView;
//                myText.setText(mContent.get(position)/*item.get("name")*/);
//       } else {
//                myText = createView(mContent.get(position)/*item.get("name")*/);
//       }
       // final Button SaveClick;
        String headerTitle = (String) mTitle.get(position);
        LayoutInflater infalInflater = (LayoutInflater) this.activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.listview_group, null);

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.textview_group_text);
//        SaveClick = (Button)convertView.findViewById(R.id.button_save);
//        SaveClick.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        SharedPreferences sort = activity.getSharedPreferences(Constants.SAVE_SORT_NAME,0);
//                        sort.edit().clear().commit();
//                        SharedPreferences.Editor editor= sort.edit();
//                        for(int i=0; i<mContent.size();i++)
//                        {
//                            editor.putString(Constants.LOOP_CODE + i, mContent.get(i)).commit();
//                        }
//                        Intent intent = new Intent();
//                        intent.setClass(activity,ExpandablelistSwitchActivity.class);
//
//                        activity.startActivity(intent);
//                        activity.finish();
//                    }
//                }
//        );
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return convertView;
    }
//   private TextView createView(String content) {
//            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
//                    ViewGroup.LayoutParams.FILL_PARENT, 80);
//            TextView myText = new TextView(activity);
//            myText.setLayoutParams(layoutParams);
//            myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
//            myText.setTextSize(25);
//            myText.setPadding(80, 0, 0, 0);
//            myText.setText(content);
//            return myText;
//        }

    public void onRemove(int which) {
        if (which < 0 || which > mContent.size()) return;
        mContent.remove(which);
        mTitle.remove(which);
    }
    public void onDrop(int from, int to) {
        String temp = mContent.get(from);
        mContent.remove(from);
        mContent.add(to, temp);
        temp = mTitle.get(from);
        mTitle.remove(from);
        mTitle.add(to, temp);
    }
}
