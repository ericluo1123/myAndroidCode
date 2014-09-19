package com.teamsourcing.LoongyeeApp.main;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.ListActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorMatrixColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.teamsourcing.LoongyeeApp.model.Device;

/**
 * Created by teamsourcing on 2014/4/11.
 */
public class ListViewSwitchActivity extends Activity {

    ListViewDragNDrop lv;
    //private int po;
    ListViewAdapter adapter;
    ArrayList<String> mTitle= new  ArrayList<String>();
    //ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
    ArrayList<String> mContent= new  ArrayList<String>();
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_switch);


        LoadAsyncTask asyncTask = new LoadAsyncTask();
        asyncTask.execute();
//        lv = (ListView) findViewById(R.id.listView_switch);
//        menuItems = new ArrayList<HashMap<String, String>>();
//        LoadData();
//        adapter = new ListViewAdapter(this, menuItems);
//        lv.setAdapter(adapter);
    }

    public void LoadData()
    {

        Device dev = new Device();
        ArrayList<Device> dataArray = dev.GetData();
        //ArrayList<Device> dataArray = dev.TestGetData();
        SharedPreferences  sort = getSharedPreferences(Constants.SAVE_SORT_NAME,0);
        //sort.edit().clear().commit();
        SharedPreferences.Editor editor=null;
        if(sort.getAll().size()!=0 && (sort.getAll().size() == dataArray.size()))
        {
            for(int j=0;j<sort.getAll().size();j++)
            {
                String lc = sort.getString(Constants.LOOP_CODE+j, "");
                for(int i=j; i< dataArray.size(); i++)
                {
                    if(dataArray.get(i).getLoopCode().equals(lc))
                    {
                        Device temp = dataArray.get(i);
                        dataArray.set(i, dataArray.get(j));
                        dataArray.set(j,temp);

                        mContent.add(dataArray.get(j).getLoopCode());
                        if(dataArray.get(j).getGoupName().equals(""))
                        {
                            mTitle.add(dataArray.get(j).getLoopCode());
                        }
                        else
                        {
                            mTitle.add(dataArray.get(j).getGoupName());
                        }
                    }
                }
                //dataArray.get(j).setLoopCode(lc);
                //mContent.add(dataArray.get(j).getLoopCode());
            }
        }
        else
        {
            editor = sort.edit();
            for(int i=0; i<dataArray.size(); i++)
            {
                editor.putString(Constants.LOOP_CODE + i, dataArray.get(i).getLoopCode()).commit();

                mContent.add(dataArray.get(i).getLoopCode());
                if(dataArray.get(i).getGoupName().equals(""))
                {
                    mTitle.add(dataArray.get(i).getLoopCode());
                }
                else
                {
                    mTitle.add(dataArray.get(i).getGoupName());
                }
            }
        }
    }
    public class LoadAsyncTask extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected String doInBackground(Integer... params) {
            LoadData();
            return "";
        }
        @Override
        protected void onPostExecute(String result) {
            lv = (ListViewDragNDrop) findViewById(R.id.listView_switch);
            adapter = new ListViewAdapter(ListViewSwitchActivity.this,mContent,mTitle);
            lv.setAdapter(adapter);

            if (lv instanceof ListViewDragNDrop) {
                ((ListViewDragNDrop) lv).setDropListener(mDropListener);
                ((ListViewDragNDrop) lv).setRemoveListener(mRemoveListener);
                ((ListViewDragNDrop) lv).setDragListener(mDragListener);
            }
            final Button btn = (Button) findViewById(R.id.button_save);
            btn.setOnClickListener(
                    new Button.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            ArrayList<String> adapterItem = adapter.getSortItem();
                            SharedPreferences sort = getSharedPreferences(Constants.SAVE_SORT_NAME, 0);
                            sort.edit().clear().commit();
                            SharedPreferences.Editor editor= sort.edit();
                            for(int i=0;i<adapterItem.size();i++)
                            {
                                editor.putString(Constants.LOOP_CODE + i, adapterItem.get(i)).commit();

                            }
                            Intent intent = new Intent();
                            intent.setClass(ListViewSwitchActivity.this,ExpandablelistSwitchActivity.class);

                            startActivity(intent);
                            finish();
                        } 
                    });
                btn.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View arg0, MotionEvent motionEvent) {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                        btn.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
                        btn.setBackgroundDrawable(btn.getBackground());
                    }
                    else if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                        btn.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
                        btn.setBackgroundDrawable(btn.getBackground());
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
                            intent.setClass(ListViewSwitchActivity.this, ExpandablelistSwitchActivity.class);

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
            ///lv.setOnItemLongClickListener(longClickListener);
            //lv.setClickable(true);
        }
    }
    private RemoveListener mRemoveListener =
            new RemoveListener() {
                public void onRemove(int which) {

                    if (adapter instanceof ListViewAdapter) {
                        ((ListViewAdapter) adapter).onRemove(which);
                        lv.invalidateViews();
//                        saveEditMsg();
                    }
                }
            };
    private DropListener mDropListener =
            new DropListener() {
                public void onDrop(int from, int to) {
//                    ListAdapter adapter = getListAdapter();
                    if (adapter instanceof ListViewAdapter) {
                        ((ListViewAdapter) adapter).onDrop(from, to);
                        lv.invalidateViews();
                     //   saveEditMsg();
                    }
                }
            };
    private DragListener mDragListener =
            new DragListener() {


                public void onDrag(int x, int y, ListView listView) {
                    // TODO Auto-generated method stub
                }

                public void onStartDrag(View itemView) {
                    itemView.setVisibility(View.INVISIBLE);
                    //ImageView iv = (ImageView) itemView.findViewById(R.id.drag_ico);
                    //if (iv != null) iv.setVisibility(View.INVISIBLE);
                    //saveEditMsg();
                }

                public void onStopDrag(View itemView) {
                    itemView.setVisibility(View.VISIBLE);
//                    ImageView iv = (ImageView) itemView.findViewById(R.id.drag_ico);
//                    if (iv != null) iv.setVisibility(View.VISIBLE);
////                    if(LedAct.mConnectedDeviceName!=null && LedAct.btService!=null){
//                    saveEditMsg();
////                    }else{
////                        Toast.makeText(getApplicationContext(),"No Device Connected ",Toast.LENGTH_SHORT).show();
////                    }
                }

            };
    private AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {
        public boolean onItemLongClick(AdapterView<?> a, View v, int position, long id) {
            //po = position;
            AlertDialog.Builder builder = new AlertDialog.Builder(ListViewSwitchActivity.this);
            //builder.setMessage(R.string.delete_msg);
            //builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    content.remove(po);
//                    adapter.notifyDataSetChanged();
//                    saveEditMsg();
//
//                }
//            });
//            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    LedAct.simulateKey(KeyEvent.KEYCODE_BACK);
//                    saveEditMsg();
//                }
//            });
            //创建并显示对话框
            //builder.create().show();
            return true;
        }
    };
    @Override
    public void onBackPressed(){

        Intent intent = new Intent();
        intent.setClass(ListViewSwitchActivity.this, ExpandablelistSwitchActivity.class);
        startActivity(intent);
        finish();

        super.onBackPressed();
    }

}
