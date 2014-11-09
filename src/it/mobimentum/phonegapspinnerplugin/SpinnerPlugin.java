package it.mobimentum.phonegapspinnerplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class SpinnerPlugin extends CordovaPlugin {
	
	private static final String PARAM_SHOW_OVERLAY = "overlay";
	private static final String PARAM_SHOW_TIMEOUT = "timeout";
	private static final String PARAM_IS_FULLSCREEN = "fullscreen";
	
	private boolean isShown = false;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		final Activity context = this.cordova.getActivity();
		
		if (action.equals("show"))
		{
			if( !isShown )
			{
				isShown = true;
				
				// Args
				JSONObject argsObj = args.getJSONObject(0);
				Boolean showOverlay = argsObj.has(PARAM_SHOW_OVERLAY) ? argsObj.getBoolean(PARAM_SHOW_OVERLAY) : null;
				Integer hideTimeout = argsObj.has(PARAM_SHOW_TIMEOUT) ? argsObj.getInt(PARAM_SHOW_TIMEOUT) : null;
				Boolean isFullScreen = argsObj.has(PARAM_IS_FULLSCREEN) ? argsObj.getBoolean(PARAM_IS_FULLSCREEN) : null;
	
				// Show
				show(context, showOverlay, hideTimeout, isFullScreen);
			}
			
			callbackContext.success();
			return true;
		}
		else if (action.equals("hide"))
		{
			if( isShown )
			{
				isShown = false;
				
				// Hide
				hide(context);
			}
			
			callbackContext.success();
			return true;
		}
		
		callbackContext.error("Spinner received invalid action '"+action+"'");
		return false;
	}
	
	private boolean show(final Activity context, Boolean showOverlay, Integer hideTimeout, Boolean isFullscreen) {
		// Loading spinner
		Intent intent = new Intent(context, ProgressActivity.class);
		if (showOverlay != null) intent.putExtra(ProgressActivity.EXTRA_SHOW_OVERLAY, showOverlay);
		if (isFullscreen != null) intent.putExtra(ProgressActivity.EXTRA_IS_FULLSCREEN, isFullscreen);
		context.startActivity(intent);
		
		if (hideTimeout != null) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() { hide(context); }
			}, hideTimeout*1000);
		}
		
		return true;
	}
	
	private boolean hide(Activity context) {
		// Loading spinner
		Intent intent = new Intent(context, ProgressActivity.class);
		intent.putExtra(ProgressActivity.ACTION_HIDE_PROGRESS, true);
		context.startActivity(intent);
		
		return true;
	}
}
