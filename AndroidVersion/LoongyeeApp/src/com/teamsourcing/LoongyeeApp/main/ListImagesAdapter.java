package com.teamsourcing.LoongyeeApp.main;

/**
 * Created by teamsourcing on 2014/4/22.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;

public class ListImagesAdapter extends BaseAdapter{
    private Context mContext;
    String LOOPCODE = "";
    String goupNo ="";
    private Integer[] mThumbIds = {
            R.drawable.pic01,
            R.drawable.pic02,
            R.drawable.pic03,
            R.drawable.pic04,
            R.drawable.pic05,
            R.drawable.pic06,
            R.drawable.pic07,
            R.drawable.pic08,
            R.drawable.pic09,
            R.drawable.pic10,
            R.drawable.pic11,
            R.drawable.pic12,
            R.drawable.pic13,
            R.drawable.pic14,
            R.drawable.pic15
    };
    public ListImagesAdapter(Context mContext, String LOOPCODE, String goupNo)
    {
        this.mContext = mContext;
        this.LOOPCODE = LOOPCODE;
        this.goupNo = goupNo;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mThumbIds.length;
    }
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return mThumbIds[arg0];
    }
    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;

        if(convertView==null){
            grid = new View(mContext);
            LayoutInflater inflater= (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid=inflater.inflate(R.layout.image_items, parent, false);
        }else{
            grid = (View)convertView;
        }
        final int pos = position;
        ImageView imageView = (ImageView)grid.findViewById(R.id.ItemImage);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setOnClickListener(

                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences images = mContext.getSharedPreferences(Constants.IMAGES, 0);
                        SharedPreferences.Editor editor=images.edit();
                        editor.putString(LOOPCODE, Integer.toString(mThumbIds[pos])).commit();
                        Intent intent = new Intent();
                        intent.putExtra("GoupNo", goupNo);
                        intent.setClass(mContext, SettingLearningActivity.class);
                        mContext.startActivity(intent);
                        ((Activity)mContext).finish();
                    }
                }
        );
        return grid;
    }
}
