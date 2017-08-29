/**
 */
package com.crowderia.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

public class AppOpener extends CordovaPlugin {
  private static final String TAG = "AppOpener";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing AppOpener");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("echo")) {
      String phrase = args.getString(0);
      // Echo back the first argument
      Log.d(TAG, phrase);
    } else if(action.equals("getDate")) {
      // An example of returning data back to the web layer
      final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
    }else if(action.equals("email")){
      Intent it = new Intent(Intent.ACTION_SEND);
      it.setType("message/rfc822");
      it.putExtra(Intent.EXTRA_EMAIL, args.getString(0));
      final PluginResult result = new PluginResult(PluginResult.Status.OK, null);
      callbackContext.sendPluginResult(result);
      this.cordova.getActivity().startActivity(Intent.createChooser(it, "Send an email..."));
    }else if(action.equals("phone")){
      Intent it = new Intent(Intent.ACTION_DIAL);
      it.setData(Uri.parse("tel:"+args.getString(0)));
      final PluginResult result = new PluginResult(PluginResult.Status.OK, null);
      callbackContext.sendPluginResult(result);
      this.cordova.getActivity().startActivity(it);
    }
    return true;
  }

}
