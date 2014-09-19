package com.teamsourcing.LoongyeeApp.main;

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 2013/12/3
 * Time: 上�?� 11:59
 * To change this template use File | Settings | File Templates.
 */

import java.io.FileNotFoundException;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.teamsourcing.LoongyeeApp.controls.Carousel;
import com.teamsourcing.LoongyeeApp.controls.CarouselAdapter;
import com.teamsourcing.LoongyeeApp.controls.CarouselAdapter.OnItemClickListener;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class TemperatureHumidityActivity extends Activity implements View.OnClickListener{

	private static final int CODE_LOCAL_PIC = 0;
	private static final int CODE_PHOTO_PIC = 1;
	private static final int CODE_GALLERY = 2;
	
	private Button 			backBtn 	= null;
	private Button 			editBtn 	= null;
	private View 			editView 	= null;
	private Dialog 			editDialog 	= null;
	private LinearLayout 	layout 		= null;
	private PopupWindow		popupWindow = null;
	
	private ImageButton imageBtn	= null;
	private Button		okBtn		= null;
	private Button		cancelBtn 	= null;
	
	private Bitmap	bitmap = null;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperaturehumidity);
        
        backBtn = (Button)findViewById(R.id.backBtn);
        editBtn = (Button)findViewById(R.id.editBtn);
        
        backBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);
        
        editView 	= View.inflate(getApplicationContext(), R.layout.temperature_humidity_edit, null);
		imageBtn 	= (ImageButton)editView.findViewById(R.id.imageButton);
		okBtn		= (Button)editView.findViewById(R.id.okButton);
		cancelBtn 	= (Button)editView.findViewById(R.id.cancelButton);
		
		imageBtn.setOnClickListener(this);
		okBtn.setOnClickListener(this);
		cancelBtn.setOnClickListener(this);
        
        editDialog =  new Dialog(this, R.style.Theme_CustomDialog);
        editDialog.setContentView(editView);
        
  }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId() == R.id.backBtn){
			
			Intent intent = new Intent();
            intent.setClass(TemperatureHumidityActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
			
		}else if(v.getId() == R.id.editBtn){
			
			// Show edit dialog			
			editDialog.show();		

		}else if(v.getId() == R.id.imageButton){
			
			View editPicView = null;editPicView = View.inflate(getApplicationContext(), R.layout.temperature_humidity_pic_edit, null);
			RelativeLayout rl_LocalPic = (RelativeLayout) editPicView.findViewById(R.id.rl_local_pic);
			RelativeLayout rl_PhotoPic = (RelativeLayout) editPicView.findViewById(R.id.rl_photo_pic);
			RelativeLayout rl_Gallery = (RelativeLayout) editPicView.findViewById(R.id.rl_gallery);
			Button pop_cancle = (Button) editPicView.findViewById(R.id.pop_cancel);

			rl_LocalPic.setOnClickListener(this);
			rl_PhotoPic.setOnClickListener(this);
			rl_Gallery.setOnClickListener(this);
			pop_cancle.setOnClickListener(this);
		
			editPicView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					popupWindow.dismiss();
				}

			});
			
			editPicView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
			LinearLayout ll_popup = (LinearLayout) editPicView.findViewById(R.id.ll_popup);
			ll_popup.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_bottom_in));
			
			if(popupWindow==null){
				popupWindow = new PopupWindow(this);
				popupWindow.setWidth(LayoutParams.MATCH_PARENT);
				popupWindow.setHeight(LayoutParams.MATCH_PARENT);
				popupWindow.setBackgroundDrawable(new BitmapDrawable());

				popupWindow.setFocusable(true);
				popupWindow.setOutsideTouchable(true);
			}
			
			popupWindow.setContentView(editPicView);
			popupWindow.showAtLocation(editView, Gravity.BOTTOM, 0, -800);
			popupWindow.update();
			
		}else if(v.getId() == R.id.okButton){
			
			editDialog.dismiss();
			
		}else if(v.getId() == R.id.cancelButton){
			
			editDialog.dismiss();
			
		}else if(v.getId() == R.id.rl_local_pic){
			
			Intent intent = new Intent();
			intent.setClass(TemperatureHumidityActivity.this,DefaultImageActivity.class);
			startActivityForResult(intent, CODE_LOCAL_PIC);
			
			popupWindow.dismiss();
			
		}else if(v.getId() == R.id.rl_photo_pic){
			
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);    
            startActivityForResult(intent, CODE_PHOTO_PIC);  
			
            popupWindow.dismiss();
			
		}else if(v.getId() == R.id.rl_gallery){
			
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
            intent.addCategory(Intent.CATEGORY_OPENABLE);  
            intent.setType("image/*");  
            startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_pic)), CODE_GALLERY);   
            
            popupWindow.dismiss();
			
		}else if(v.getId() == R.id.pop_cancel){
			
			popupWindow.dismiss();
		}
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	    super.onActivityResult(requestCode, resultCode, data);  
	    if(resultCode == RESULT_OK){ 
	    	switch(requestCode){
	    	
	    	case CODE_LOCAL_PIC:
	    		int iResourceId = data.getIntExtra("resourceid", 0);
	    		if(iResourceId != 0)
	    			imageBtn.setBackgroundResource(iResourceId);
	    		break;
	    		
	    	case CODE_PHOTO_PIC:{
	    		Bundle bundle = data.getExtras();
	    		
	    		if(bitmap != null)//如果不释放的话，不断取图片，将会内存不够  
		           	bitmap.recycle();
	    		 
	    		bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
	            BitmapDrawable bd = new BitmapDrawable(getResources(),bitmap);
	            Drawable drawable = (Drawable)bd;
	            imageBtn.setBackgroundDrawable(drawable);		        
	    	}break;
	    	
	    	case CODE_GALLERY:
	    		
	    		Uri uri = data.getData();
	 	        ContentResolver cr = this.getContentResolver();   
		        try {  
		            if(bitmap != null)//如果不释放的话，不断取图片，将会内存不够  
		            	bitmap.recycle();
		            
		            bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
		            BitmapDrawable bd = new BitmapDrawable(getResources(),bitmap);
		            Drawable drawable = (Drawable)bd;
		            imageBtn.setBackgroundDrawable(drawable);
		            
		        } catch (FileNotFoundException e) {  
		            // TODO Auto-generated catch block  
		            e.printStackTrace();  
		        }  
	    		break;
	    	}
	   } 
	}
	
	@Override
	public void onBackPressed(){
		
		Intent intent = new Intent();
        intent.putExtra("ItemNo", String.valueOf(0));
        intent.setClass(TemperatureHumidityActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        
		super.onBackPressed();		
	}
}
