package it.mobimentum.phonegapspinnerplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ProgressActivity extends Activity {
	
	public static final String ACTION_HIDE_PROGRESS = "ProgressActivity.ACTION_HIDE_PROGRESS";
	
//	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			finish();
//		}
//	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Intent
		Intent intent = getIntent();
		if (intent.hasExtra(ACTION_HIDE_PROGRESS)) {
			finish();
			return;
		}

		// ProgressBar
		ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		bar.setLayoutParams(params);
		bar.setBackgroundColor(Color.TRANSPARENT);
		
		// Layout
		RelativeLayout layout = new RelativeLayout(this);
		layout.setBackgroundColor(Color.parseColor("#cc000000"));
		layout.addView(bar);
		
		// Theme
		setTheme(android.R.style.Theme_Translucent_NoTitleBar);
		setContentView(layout);
		
		// Receiver to hide spinner
//		registerReceiver(mBroadcastReceiver, new IntentFilter(ACTION_HIDE_PROGRESS));

		// Test hide
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
//				Intent intent = new Intent(ProgressActivity.ACTION_HIDE_PROGRESS);
//				sendBroadcast(intent);
				
				Intent intent = new Intent(getApplicationContext(), ProgressActivity.class);
				intent.putExtra(ProgressActivity.ACTION_HIDE_PROGRESS, true);
				startActivity(intent);
			}
		}, 5000);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
//		unregisterReceiver(mBroadcastReceiver);
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		if (intent.hasExtra(ACTION_HIDE_PROGRESS)) {
			finish();
			return;
		}
		
		super.onNewIntent(intent);
	}
}
