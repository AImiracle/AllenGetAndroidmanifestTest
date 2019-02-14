package com.mintegral.allenliu.checkTool;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;


public class CommonUtil {
    private  final String TAG="allen";
    private  static final String REWARD="com.mintegral.msdk.reward";
    private  Context context;
    public CommonUtil(Context context){
       this.context=context;
    }

    public void check(){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    REWARD, PackageManager.GET_ACTIVITIES);
            if (packageInfo==null){
                Log.e(TAG,"kong");

            }
            for (ActivityInfo activity : packageInfo.activities) {
                Log.e(TAG,activity.name);
            }

        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }
}
