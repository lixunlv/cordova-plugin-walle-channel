package com.baicao.walle;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import com.meituan.android.walle.WalleChannelReader;

public class WalleChannelPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if ("getChannel".equals(action)) {
      String channel = WalleChannelReader.getChannel(cordova.getActivity().getApplicationContext());
      callbackContext.success(channel == null ? "" : channel);
      return true;
    }
    return false;
  }
}
