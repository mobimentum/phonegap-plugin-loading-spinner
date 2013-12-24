package it.mobimentum.phonegapspinnerplugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class SpinnerPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		final Activity context = this.cordova.getActivity();
		
		if (action.equals("show")) {
			// cfr. http://devgirl.org/2013/09/17/how-to-write-a-phonegap-3-0-plugin-for-android/
			
			// Test con Toast
			JSONObject argsObj = args.getJSONObject(0);
			String msg = argsObj.getString("msg");
			Toast.makeText(context, "show(): test ok, msg: "+msg, Toast.LENGTH_LONG).show();
			
			// Loading spinner
			Intent intent = new Intent(context, ProgressActivity.class);
			context.startActivity(intent);
			
			callbackContext.success();
			
			return true;
		}
		else if (action.equals("hide")) {
			// Test con Toast
			Toast.makeText(context, "hide(): test ok", Toast.LENGTH_LONG).show();
			
			// Loading spinner
//			Intent intent = new Intent(ProgressActivity.ACTION_HIDE_PROGRESS);
//			context.sendBroadcast(intent);
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