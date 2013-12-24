package it.mobimentum.phonegapspinnerplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ProgressActivity extends Activity {
	
	public static final String ACTION_HIDE_PROGRESS = "ProgressActivity.ACTION_HIDE_PROGRESS";
	
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) { finish(); }
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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
		registerReceiver(mBroadcastReceiver, new IntentFilter(ACTION_HIDE_PROGRESS));
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		unregisterReceiver(mBroadcastReceiver);
	}
}
