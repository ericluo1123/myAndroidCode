package com.example.simpleui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.impl.conn.Wire;

import com.parse.*;

import android.R.raw;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.util.Log;

public class messageActivity extends Activity {

	// private TextView textView;
	private ListView listView;
	private ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Log.d("debug", "message Activity !!");
		setContentView(R.layout.activity_message);
		listView = (ListView) findViewById(R.id.listView1);
		// textView = (TextView) findViewById(R.id.textView1);

		String text = getIntent().getStringExtra("text");
		Boolean checked = getIntent().getBooleanExtra("checked", false);

		progressDialog =new ProgressDialog(this);
		progressDialog.setTitle("Loading ... ");
		progressDialog.show();
		
		writeFile(text, checked);
		saveToParse(text, checked);
		
		
		
		// String data = (readFile());
		// ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
		// android.R.layout.simple_list_item_1 , data.split("\n"));

//		String[] rawData = readFile().split("\n");
//		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
//
//		for (int i = 0; i < rawData.length - 1; i++) {
//			String[] d = rawData[i].split(",");
//
//			Map<String, String> item = new HashMap<String, String>();
//			item.put("text", d[0]);
//			item.put("checked", d[1]);
//			data.add(item);
//		}
//
//		String[] from = new String[] { "text", "checked" };
//		int[] to = new int[] { android.R.id.text1, android.R.id.text2 };
//
//		SimpleAdapter adapter = new SimpleAdapter(this, data,
//				android.R.layout.simple_list_item_2, from, to);
//
//		listView.setAdapter(adapter);
	}

	

	private void saveToParse(String text, boolean checked) {

		ParseObject messageObject = new ParseObject("message");
		messageObject.put("text", text);
		messageObject.put("checked", checked);
		messageObject.saveInBackground(new SaveCallback() {
			
			@Override
			public void done(ParseException e) {
				// TODO Auto-generated method stub
				loadMessageFormParse();
				progressDialog.dismiss();
			}
		});
	}

	private void loadMessageFormParse() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("message");
		// query.whereEqualTo("playerName", "Dan Stemkoski");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> messages, ParseException e) {

				setListView(messages);
			}
		});
	}
	
	private void setListView(List<ParseObject> messages) {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		for (ParseObject message : messages) {
			Map<String, String> item = new HashMap<String, String>();
			item.put("text", message.getString("text"));
			item.put("checked",""+message.getBoolean("checked"));
			data.add(item);
		}

		String[] from = new String[] { "text", "checked" };
		int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

		SimpleAdapter adapter = new SimpleAdapter(this, data,
				android.R.layout.simple_list_item_2, from, to);

		listView.setAdapter(adapter);
	}

	private void writeFile(String text, boolean checked) {
		text += "," + checked + "\n";
		try {
			FileOutputStream fos = openFileOutput("history.txt",
					Context.MODE_APPEND);
			fos.write(text.getBytes());
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String readFile() {
		try {
			FileInputStream fis = openFileInput("history.txt");
			byte[] buffer = new byte[1024];
			fis.read(buffer);
			fis.close();

			return new String(buffer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
