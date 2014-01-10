package it.mobimentum.phonegapspinnerplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

public class SpinnerPlugin extends CordovaPlugin {

	private static final String PARAM_SHOW_OVERLAY = "overlay";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		// cfr. http://devgirl.org/2013/09/17/how-to-write-a-phonegap-3-0-plugin-for-android/

		final Activity context = this.cordova.getActivity();
		
		// Get action
		if (action.equals("show")) {
			
			// Params
			JSONObject argsObj = args.getJSONObject(0);
			Boolean showOverlay = argsObj.has(PARAM_SHOW_OVERLAY) ? argsObj.getBoolean(PARAM_SHOW_OVERLAY) : null;
			
			// Show loading spinner
			Intent intent = new Intent(context, ProgressActivity.class);
			if (showOverlay != null) intent.putExtra(ProgressActivity.EXTRA_SHOW_OVERLAY, showOverlay);
			context.startActivity(intent);
			
			callbackContext.success();
			
			return true;
		}
		else if (action.equals("hide")) {
			// Hide loading spinner
			Intent intent = new Intent(context, ProgressActivity.class);
			intent.putExtra(ProgressActivity.ACTION_HIDE_PROGRESS, true);
			context.startActivity(intent);
			
			callbackContext.success();			
			
			return true;
		}
		
		callbackContext.error("Invalid action");
		
		return false;
	}
}