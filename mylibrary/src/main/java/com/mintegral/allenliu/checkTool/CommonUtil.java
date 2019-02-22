package com.mintegral.allenliu.checkTool;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.HashMap;


public class CommonUtil {
    private  final String TAG="mintegral_allen";
    /**
     * 包名
     */
    private  static final String mintegral_reward="com.mintegral.msdk.reward.player.MTGRewardVideoActivity";
    private  static final String mintegral_common="com.mintegral.msdk.MIntegralConstans";
    private  static final String mintegral_mtgnative="com.mintegral.msdk.mtgnative.controller.NativeController";
    private  static final String mintegral_alphab="com.alphab.Operation";
    private  static final String mintegral_interstitial="com.mintegral.msdk.interstitial.view.MTGInterstitialActivity";
    private  static final String mintegral_appwall="com.mintegral.msdk.appwall.WallFragment";
    private  static final String mintegral_intersitialvideo="com.mintegral.msdk.interstitialvideo.out.MTGInterstitialVideoHandler";
    private  static final String mintegral_interactiveads="com.mintegral.msdk.interactiveads.out.MTGInteractiveHandler";
    private  static final String mintegral_videocommon="com.mintegral.msdk.videocommon.view.MyImageView";
    private  static final String mintegral_mtgdownloads="com.mintegral.msdk.pluginFramework.PluginService";
    private  static final String mintegral_playercommon="com.mintegral.msdk.playercommon.PlayerView";
    private  static final String mintegral_videojs="com.mintegral.msdk.video.js.activity.AbstractActivity";
    private  static final String mintegral_mtgjscommon="com.mintegral.msdk.mtgjscommon.authority.activity.MTGAuthorityActivity";
    private  static final String mintegral_nativeex="com.mintegral.msdk.nativex.view.MTGMediaView";
    /**
     * 权限
     */
    private static String[]permissionsREAD={
            Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE,
    };

    private static String[]permissionsREADChina={
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.REQUEST_INSTALL_PACKAGES};
    /**
     * 组件
     */

    private static final String mtgFileProvider="com.mintegral.msdk.base.utils.MTGFileProvider";
    private static final String mtgRewardVideoActivity="com.mintegral.msdk.reward.player.MTGRewardVideoActivity";
    private static final String mtgActivity="com.mintegral.msdk.shell.MTGActivity";
    private static final String mtgCommonActivity="com.mintegral.msdk.activity.MTGCommonActivity";
    private static final String appReceiver="com.mintegral.msdk.click.AppReceiver";
    private static final String mtgService="com.mintegral.msdk.shell.MTGService";

    private  Context context;
    private HashMap<String,String> hashMap;

    private static boolean isIntegrateCompleted=true;
    public CommonUtil(Context context){
        this.context=context;
        hashMap=new HashMap<>();
        hashMap.put(mintegral_reward,"mintegral_reward");
        hashMap.put(mintegral_common,"mintegral_common");
        hashMap.put(mintegral_mtgnative,"mintegral_mtgnative");
        hashMap.put(mintegral_alphab,"mintegral_alphab");
        hashMap.put(mintegral_interstitial,"mintegral_interstitial");
        hashMap.put(mintegral_appwall,"mintegral_appwall");
        hashMap.put(mintegral_intersitialvideo,"mintegral_intersitialvideo");
        hashMap.put(mintegral_interactiveads,"mintegral_interactiveads");
        hashMap.put(mintegral_videocommon,"mintegral_videocommon");
        hashMap.put(mintegral_mtgdownloads,"mintegral_mtgdownloads");
        hashMap.put(mintegral_playercommon,"mintegral_playercommon");
        hashMap.put(mintegral_videojs,"mintegral_videojs");
        hashMap.put(mintegral_mtgjscommon,"mintegral_mtgjscommon");
        hashMap.put(mintegral_nativeex,"mintegral_nativeex");

    }

    public void checkRewardVideo(boolean isChina){
        checkPackage(mintegral_nativeex);
        checkPackage(mintegral_mtgnative);
        checkPackage(mintegral_appwall);
        checkPackage(mintegral_intersitialvideo);
        checkPackage(mintegral_interstitial);
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_interactiveads);
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_common);
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_reward);
        checkPackage(mintegral_playercommon);
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_videojs);
        checkPackage(mintegral_mtgdownloads);
        checkPackage(mintegral_mtgjscommon);
        checkActivity(mtgRewardVideoActivity);
        checkPermission(isChina);
        if (checkIsChinaPkg()){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"RewardVideo基本集成没有问题");
        }
    }

    public void checkNative(boolean isChina){
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_mtgnative);
        checkPackage(mintegral_nativeex);
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_common);
        checkPackage(mintegral_playercommon);
        checkPackage(mintegral_videojs);
        checkPackage(mintegral_common);
        checkPackage(mintegral_mtgdownloads);
        if (isChina){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"Native(NativeVideo)基本集成没有问题");
        }
    }

    public void checkAppWall(boolean isChina){

        checkPackage(mintegral_alphab);
        checkPackage(mintegral_appwall);
        checkPackage(mintegral_common);
        checkPackage(mintegral_mtgdownloads);
        checkService(mtgActivity);
        if (isChina){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"AppWall基本集成没有问题");
        }
    }

    public void checkInterstitial(boolean isChina){
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_interstitial);
        checkPackage(mintegral_common);
        checkPackage(mintegral_mtgjscommon);
        checkPackage(mintegral_mtgdownloads);
        if (isChina){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"Interstitil基本集成没有问题");
        }
    }

    public void checkInterstitialVideo(Boolean isChina){
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_mtgnative);
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_intersitialvideo);
        checkPackage(mintegral_reward);
        checkPackage(mintegral_playercommon);
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_videojs);
        checkPackage(mintegral_mtgdownloads);
        checkPackage(mintegral_mtgjscommon);
        checkActivity(mtgRewardVideoActivity);
        checkPermission(isChina);
        if (isChina){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"基本集成没有问题");
        }
    }

    public void checkInterActive(boolean isChina){
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_alphab);
        checkPackage(mintegral_interactiveads);
        checkPackage(mintegral_videocommon);
        checkPackage(mintegral_mtgdownloads);
        checkPackage(mintegral_mtgjscommon);
        checkPermission(isChina);
        if (isChina){
            checkChinaSituation();
        }
        if (isIntegrateCompleted){
            Log.i(TAG,"基本集成没有问题");
        }
    }

    private void checkPackage(String name){
        try {
            Class mClass = Class.forName(name);
        }catch (ClassNotFoundException e){
            isIntegrateCompleted=false;
            Log.i(TAG,"没有添加"+hashMap.get(name)+"包");
        }
    }

    private void checkActivity(String activityname){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (activityname!=null){
                for (ActivityInfo activity : packageInfo.activities) {
                    if (activityname.equals(activity.name)){
                        return ;
                    }
                }
                Log.i(TAG,"没有添加"+activityname);
                isIntegrateCompleted=false;
            }
        }catch (PackageManager.NameNotFoundException e){
            isIntegrateCompleted=false;
        }
    }

    private void checkProvider(String providername){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_PROVIDERS);
            if (providername!=null){
                for (ProviderInfo provider : packageInfo.providers) {
                    if (providername.equals(provider.name)){
                        return ;
                    }
                }
                Log.i(TAG,"没有添加"+providername);
                isIntegrateCompleted=false;
            }

        }catch (PackageManager.NameNotFoundException e){
            isIntegrateCompleted=false;
        }
    }


    private void checkService(String serviceername){
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SERVICES);
            if (serviceername!=null){
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if (serviceername.equals(serviceInfo.name)){
                        return ;
                    }
                }
                Log.i(TAG,"没有添加"+serviceername);
                isIntegrateCompleted=false;
            }

        }catch (PackageManager.NameNotFoundException e){
//            Log.e(TAG,"没有添加"+packagename+"包");
            isIntegrateCompleted=false;
        }
    }

    private void checkPermission(boolean isChina){
        for (int i = 0; i <permissionsREAD.length; i++) {
            if (ContextCompat.checkSelfPermission(context,permissionsREAD[i])==PackageManager.PERMISSION_DENIED){
                Log.i(TAG,permissionsREAD[i]+"权限没有打开");
                isIntegrateCompleted=false;
            }
        }
        if (isChina){
            for (int i = 0; i <permissionsREADChina.length; i++) {
                if (ContextCompat.checkSelfPermission(context,permissionsREADChina[i])==PackageManager.PERMISSION_DENIED){
                    Log.i(TAG,permissionsREADChina[i]+"权限没有打开");
                    isIntegrateCompleted=false;
                }
            }
        }
    }
    private void checkChinaSituation(){
        checkProvider(mtgFileProvider);
        checkService(appReceiver);
        checkActivity(mtgCommonActivity);
        checkService(mtgService);
    }

    private boolean checkIsChinaPkg(){
        boolean isChina=false;
        try {
            Object object=new Object();
            Class mClass = Class.forName("com.mintegral.msdk.out.MTGConfiguration");
            Field[] fs = mClass.getFields();
            Field field=fs[1];
            field.setAccessible(true);
            String msg=""+field.get(object);
            if(msg.contains("01")){
//                return true;
                isChina=true;
            }else{
                isChina=false;
            }
        }catch (ClassNotFoundException e){
            isIntegrateCompleted=false;
//            Log.i(TAG,"没有添加"+hashMap.get(name)+"包");
        }catch (IllegalAccessException e){
            isIntegrateCompleted=false;
        }
        return isChina;
    }
}
