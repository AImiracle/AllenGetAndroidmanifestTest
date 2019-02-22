package com.example.liufeng.allengetandroidmanifesttest;

import android.app.Activity;
import android.os.Bundle;

import com.mintegral.allenliu.checkTool.CommonUtil;


public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MtgNativeHandler
//        final MIntegralSDK sdk = MIntegralSDKFactory.getMIntegralSDK();
        CommonUtil commonUtil=new CommonUtil(getApplicationContext());
        commonUtil.checkRewardVideo(true);

    }
}
