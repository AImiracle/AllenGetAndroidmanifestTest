package com.example.liufeng.allengetandroidmanifesttest;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class MyHandler extends Handler {
//    public  static final int MTG_HIDE_LOADING=102;
//    public  static final int MTG_UPDATE_TRUE=100;
//    public  static final int MTG_UPDATE_FALSE=101;
//
//    private final WeakReference<MainActivity> mActivity;
//
//    public MyHandler(MainActivity activity) {
//        mActivity = new WeakReference<MainActivity>(activity);
//    }
//
//    @Override
//    public void handleMessage(Message msg) {
//        MainActivity activity = mActivity.get();
//        if (activity!=null){
//            String s=msg.obj+"";
//            if (msg.obj!=null){
//                switch (msg.what){
//                    case MTG_UPDATE_FALSE:
//                        activity.addTextView(false,s);
//                        break;
//                    case MTG_UPDATE_TRUE:
//                        activity.addTextView(true,s);
//                        break;
//                    case MTG_HIDE_LOADING:
//                        activity.changeTextView("结果输出完毕");
//                        break;
//                }
//            }
//        }
//    }
}

//    private static XmlResourceParser getBinaryXmlParser(Context context, String binaryFilePath, String binaryXmlFileName)
//            throws ReflectiveOperationException, IOException {
//        if (TextUtils.isEmpty(binaryFilePath) || TextUtils.isEmpty(binaryXmlFileName)) {
//            return null;
//        }
//        AssetManager assetManager = context.getAssets();
//        Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
//        addAssetPath.setAccessible(true);
//        int cookie = (int) addAssetPath.invoke(assetManager, binaryFilePath);
//        return assetManager.openXmlResourceParser(cookie, binaryXmlFileName);
//    }