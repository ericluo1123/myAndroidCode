package com.teamsourcing.LoongyeeApp.main;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class DefaultImageActivity extends Activity implements View.OnClickListener{

	private GridView gridView = null;
	private Button backBtn = null;
	
	//references to our images
    private Integer[] mThumbIds = {
            R.drawable.pic01, R.drawable.pic02,
            R.drawable.pic03, R.drawable.pic04,
            R.drawable.pic05, R.drawable.pic06,
            R.drawable.pic07, R.drawable.pic08,
            R.drawable.pic09, R.drawable.pic10,
            R.drawable.pic11, R.drawable.pic12,
            R.drawable.pic13, R.drawable.pic14,
            R.drawable.pic15
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_default_image);
		
		backBtn = (Button)findViewById(R.id.backBtn);
		backBtn.setOnClickListener(this);
		
		gridView = (GridView)findViewById(R.id.gridView);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setOnItemClickListener(new ItemClickListener()); 
	}

	class  ItemClickListener implements OnItemClickListener	{
		
		@Override
		public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened   
		                                  View arg1,//The view within the AdapterView that was clicked  
		                                  int arg2,//The position of the view in the adapter  
		                                  long arg3//The row id of the item that was clicked  
		                                  ) {
			Intent intent = new Intent();
			intent.putExtra("resourceid", mThumbIds[arg2]);
            setResult(RESULT_OK, intent);
            finish();
		}	
	
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.backBtn){
			
			//数据是使用Intent返回
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
		}
		
	}
	
	public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        
     
 
        public ImageAdapter(Context c) {
            mContext = c;
        }
 
        public int getCount() {
            return mThumbIds.length;
        }
 
        public Object getItem(int position) {
            return null;
        }
 
        public long getItemId(int position) {
            return 0;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
 
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
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
