package it.mobimentum.phonegapspinnerplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.widget.Toast;

public class SpinnerPlugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		final Activity activity = this.cordova.getActivity();
		
		if (action.equals("show")) {
			// cfr. http://devgirl.org/2013/09/17/how-to-write-a-phonegap-3-0-plugin-for-android/
			JSONObject argsObj = args.getJSONObject(0);
			String msg = argsObj.getString("msg");
			Toast.makeText(activity, "show(): test ok, msg: "+msg, Toast.LENGTH_LONG).show();
			callbackContext.success();
			
			return true;
		}
		else if (action.equals("hide")) {
			Toast.makeText(activity, "hide(): test ok", Toast.LENGTH_LONG).show();
			callbackContext.success();			
			
			return true;
		}
		
		callbackContext.error("Invalid action");
		
		return false;
	}
}
