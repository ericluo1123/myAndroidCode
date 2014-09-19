package com.teamsourcing.LoongyeeApp.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by teamsourcing on 2014/4/22.
 */
public class ListImagesActivity extends Activity {

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

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_images);
        GridView gridview = (GridView) findViewById(R.id.gridView);
        Intent intent=getIntent();
        String value=intent.getStringExtra("LOOPCODE");
        String goupNo = intent.getStringExtra("GoupNo");
        gridview.setAdapter(new ListImagesAdapter(ListImagesActivity.this, value, goupNo));

        final Button Back = (Button) findViewById(R.id.back);
        Back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(ListImagesActivity.this, SettingLearningActivity.class);
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
    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.setClass(ListImagesActivity.this, SettingLearningActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }
}
