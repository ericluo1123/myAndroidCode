package com.example.simplepush;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.PushService;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText editText;
	private Spinner spinner;
	private LinearLayout linearLayout;
	private MyCustomReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "7l5Z9eV6OxMQib9gma1hzQZin3oDjmxmckBqNnbe",
				"3bWeunqIQJVudejWipAx2yUB15KmnqYunILxyy0G");
		PushService.setDefaultPushCallback(this, MainActivity.class);
		// When users indicate they are Giants fans, we subscribe them to that
		// channel.
		PushService.subscribe(this, "all", MainActivity.class);
		PushService.subscribe(this, "device_" + getDevi1ceId(),
				MainActivity.class);

		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.editText1);
		spinner = (Spinner) findViewById(R.id.spinner1);
		linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

		saveDeviceId();
		getDeviceIds();

		IntentFilter IntentFilter =new IntentFilter();
		IntentFilter.addAction("com.example.UPDATE_STATUS");
		receiver = new MyCustomReceiver();
		registerReceiver(receiver, IntentFilter);
	}

	private void getDeviceIds() {
		// TODO Auto-generated method stub
		ParseQuery<ParseObject> query = new ParseQuery<>("DeviceId");
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				// TODO Auto-generated method stub
				List<String> ids = new ArrayList<String>();
				for (ParseObject obj : objects) {
					if (obj.has("deviceId")
							&& obj.getString("deviceId") != null) {
						ids.add(obj.getString("deviceId"));
					}
					ArrayAdapter<String> adapter = new ArrayAdapter<>(
							MainActivity.this,
							android.R.layout.simple_spinner_item, ids);
					spinner.setAdapter(adapter);
				}

			}
		});
	}

	private void saveDeviceId() {
		// TODO Auto-generated method stub
		ParseObject parseObject = new ParseObject("DeviceId");
		parseObject.put("deviceId", getDevi1ceId());
		parseObject.saveInBackground();

	}

	public void send(View view) {

		String text = editText.getText().toString();
		String channel = "device_" + spinner.getSelectedItem();
		JSONObject data;
		data = new JSONObject();

		try {
			data.put("action", "com.example.UPDATE_STATUS");
			data.put("text", text);
			data.put("newItem", "newItem");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ParsePush parsePush = new ParsePush();
		parsePush.setChannel(channel);
		parsePush.setData(data);

		// parsePush.setMessage(text);
		parsePush.sendInBackground();

	}

	public void send2() {

	}

	public String getDevi1ceId() {
		return Secure.getString(getContentResolver(), Secure.ANDROID_ID);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public class MyCustomReceiver extends BroadcastReceiver {
		private static final String TAG = "MyCustomReceiver";

		@Override
		public void onReceive(Context context, Intent intent) {
			try {
				String action = intent.getAction();
				String channel = intent.getExtras().getString(
						"com.parse.Channel");
				JSONObject json = new JSONObject(intent.getExtras().getString(
						"com.parse.Data"));

				Log.d(TAG, "got action " + action + " on channel " + channel
						+ " with:");
				Iterator itr = json.keys();
				while (itr.hasNext()) {
					String key = (String) itr.next();
					Log.d(TAG, "..." + key + " => " + json.getString(key));
					if ("text".equals(key)) {
						String text = json.getString(key);
						TextView textView = new TextView(context);
						textView.setText(text);
						linearLayout.addView(textView);
					}
				}
			} catch (JSONException e) {
				Log.d(TAG, "JSONException: " + e.getMessage());
			}
		}
	}

}
