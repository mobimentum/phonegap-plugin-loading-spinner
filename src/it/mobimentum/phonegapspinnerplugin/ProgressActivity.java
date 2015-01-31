package it.mobimentum.phonegapspinnerplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ProgressActivity extends Activity {
	
	public static final String ACTION_HIDE_PROGRESS = "ProgressActivity.ACTION_HIDE_PROGRESS";

	public static final String EXTRA_SHOW_OVERLAY = "ProgressActivity.EXTRA_SHOW_OVERLAY";
	
	public static final String EXTRA_IS_FULLSCREEN = "ProgressActivity.EXTRA_IS_FULLSCREEN";
	
	private static final String TAG = ProgressActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Intent
		Intent intent = getIntent();
		Log.i(TAG, "Intent: "+intent.getAction()+" / "+intent.hasExtra(ACTION_HIDE_PROGRESS));
		if (intent.hasExtra(ACTION_HIDE_PROGRESS)) {
			finish();
			this.overridePendingTransition(0, 0);
			
			return;
		}
		
		// Parameters
		Bundle extras = intent.getExtras();
		boolean showOverlay = extras == null || extras.getBoolean(EXTRA_SHOW_OVERLAY, true);
		boolean isFullscreen = extras != null && extras.getBoolean(EXTRA_IS_FULLSCREEN, false);

		// Fullscreen
		if (isFullscreen) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}

		// ProgressBar
		ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		bar.setLayoutParams(params);
		bar.setBackgroundColor(Color.TRANSPARENT);
		
		// Layout
		RelativeLayout layout = new RelativeLayout(this);
		if (showOverlay) layout.setBackgroundColor(Color.parseColor("#aa000000"));
		layout.addView(bar);
		
		// Theme
		setTheme(android.R.style.Theme_Translucent_NoTitleBar);
		setContentView(layout);
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		Log.i(TAG, "Intent: "+intent.getAction()+" / "+intent.hasExtra(ACTION_HIDE_PROGRESS));
		if (intent.hasExtra(ACTION_HIDE_PROGRESS)) {
			finish();
			this.overridePendingTransition(0, 0);
			
			return;
		}
		
		super.onNewIntent(intent);
	}
}
