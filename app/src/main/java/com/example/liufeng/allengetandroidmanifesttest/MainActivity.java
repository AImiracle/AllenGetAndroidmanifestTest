package com.example.liufeng.allengetandroidmanifesttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liufeng.allengetandroidmanifesttest.res.AXmlResourceParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import dalvik.system.PathClassLoader;

public class MainActivity extends Activity {
//    public static final String TAG="ALLEN_MainActivity";
//    private Button button;
//    private LinearLayout linearLayoutContainer;
//    private TextView textView;
//    InputStream inputStream = null;
//    ZipFile zipFile = null;
//    MyHandler myHandler;
//
//
//    /**
//     * 需要检测的项目map
//     * @param savedInstanceState
//     */
//    HashMap<String,Boolean> hashMap =new HashMap<>();
//
//    /**
//     * 需要检测的key
//     * @param savedInstanceState
//     */
//    public final String LIST1="android.permission.INTERNET";
//    public final String LIST2="android.permission.WRITE_EXTERNAL_STORAGE";
//    public final String LIST3="android.permission.ACCESS_NETWORK_STATE";
//    public final String LIST4="android.permission.REQUEST_INSTALL_PACKAGES";
//    public final String LIST5="android.permission.READ_PHONE_STATE";
//    public final String LIST6="com.mintegral.msdk.activity.MTGCommonActivity";
//    public final String LIST7="com.mintegral.msdk.click.AppReceiver";
//    public final String LIST8="com.mintegral.msdk.shell.MTGService";
//    public final String LIST9="com.mintegral.msdk.base.utils.MTGFileProvider";
//    public final String LIST10=".mtgFileProvider";
//    public final String LIST11="com.mintegral.msdk.reward.player.MTGRewardVideoActivity";
//
//
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        button=(Button) findViewById(R.id.m_button);
//        linearLayoutContainer=(LinearLayout) findViewById(R.id.m_ll);
//        textView=(TextView) findViewById(R.id.m_table);
//        myHandler=new MyHandler(MainActivity.this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //每次检测之前先清楚hashmap,再进行初始化下hashmap
//                hashMap.clear();
//                addList();//初始化checklist
//                doCheck();
//                textView.setVisibility(View.VISIBLE);
//                textView.setText("正在输出结果.....");
//            }
//        });
//    }
//
//    private void doCheck() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    checkDEX();
////                    String  apkPath=MainActivity.this.getPackageManager().getApplicationInfo("com.mintegral.sdk.demo", 0).sourceDir;
////                    int tatgetSDKVersion=MainActivity.this.getPackageManager().getApplicationInfo("com.mintegral.sdk.demo", 0).targetSdkVersion;
////
////                    if (extractAndroidManifest(apkPath)){
////                        try {
////                            parseAndroidManifest();
////                        }catch (Exception e){
////                            e.printStackTrace();
////                        }finally {
////                            if (inputStream != null) {
////                                try {
////                                    inputStream.close();
////                                } catch (IOException e) {
////                                    e.printStackTrace();
////                                }
////                            }
////                            if (zipFile != null) {
////                                try {
////                                    zipFile.close();
////                                } catch (IOException e) {
////                                    e.printStackTrace();
////                                }
////                            }
////                        }
////                    }
////
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//    }
//
//
//
//
//
//    public boolean extractAndroidManifest(String apkPath) {
//
//        try {
//            zipFile = new ZipFile(apkPath);
//            ZipEntry entry = zipFile.getEntry("AndroidManifest.xml");
//            inputStream = zipFile.getInputStream(entry);
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    /**
//     * 解析 AndroidManifest.xml
//     */
//    public void parseAndroidManifest() throws XmlPullParserException, IOException {
//        AXmlResourceParser parser = new AXmlResourceParser();
//        parser.open(inputStream);
//        StringBuilder indent = new StringBuilder(10);
//        while (true) {
//            int type = parser.next();
//            if (type == XmlPullParser.END_DOCUMENT) {
//                break;
//            }
//            switch (type) {
//                case XmlPullParser.START_DOCUMENT:
//                    break;
//                case XmlPullParser.START_TAG:
//                    int namespaceCountBefore = parser.getNamespaceCount(parser.getDepth() - 1);
//                    int namespaceCount = parser.getNamespaceCount(parser.getDepth());
//                    for (int i = namespaceCountBefore; i != namespaceCount; ++i) {
////                        Log.d("结果1:"+"%sxmlns:%s=\"%s\"",
////                                indent+
////                                        parser.getNamespacePrefix(i)+
////                                        parser.getNamespaceUri(i));
//
//                    }
//                    for (int i = 0; i != parser.getAttributeCount(); ++i) {
//
//                        Log.d("结果2:"+"%s%s%s=\"%s\"",
//                                indent+"=="+
//                                        getNamespacePrefix(parser.getAttributePrefix(i))+"===="+
//                                        parser.getAttributeName(i)+"===="+
//                                        getAttributeValue(parser, i));
//                        String s=getAttributeValue(parser,i);
//                        checkSetting(s);
//                    }
//                    break;
//                case XmlPullParser.END_TAG:
////                    Log.d("结果4","===========================/n");
//                    break;
//                case XmlPullParser.TEXT:
//////                    Log.d("结果3:"+"%s%s%s=\"%s\"",
////                            indent+
////                                    parser.getText());
//                default:
//                    break;
//            }
//        }
//        //遍历结束后，将没配置的打印出来
//        for(Object key: hashMap.keySet()){
//            if(hashMap.get(key).equals(false)){
//                sendMessage(MyHandler.MTG_UPDATE_FALSE,key+"  未配置");
//            }
//        }
//        //最后发送检测结束的handler
//        sendMessage(MyHandler.MTG_HIDE_LOADING,"");
//
//    }
//
//    private static String getNamespacePrefix(String prefix) {
//        if (prefix == null || prefix.length() == 0) {
//            return "";
//        }
//        return prefix + ":";
//    }
//
//    private static String getAttributeValue(AXmlResourceParser parser, int index) {
//        int type = parser.getAttributeValueType(index);
//        int data = parser.getAttributeValueData(index);
//        if (type == TypedValue.TYPE_ATTRIBUTE) {
//            return String.format("?%s%08X", getPackage(data), data);
//        }
//        if (type == TypedValue.TYPE_INT_BOOLEAN) {
//            return data != 0 ? "true" : "false";
//        }
//        if (type == TypedValue.TYPE_DIMENSION) {
//            return Float.toString(complexToFloat(data)) + DIMENSION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
//        }
//        if (type == TypedValue.TYPE_FLOAT) {
//            return String.valueOf(Float.intBitsToFloat(data));
//        }
//        if (type == TypedValue.TYPE_FRACTION) {
//            return Float.toString(complexToFloat(data)) + FRACTION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
//        }
//        if (type == TypedValue.TYPE_INT_HEX) {
//            return String.format("0x%08X", data);
//        }
//        if (type == TypedValue.TYPE_REFERENCE) {
//            return String.format("@%s%08X", getPackage(data), data);
//        }
//        if (type == TypedValue.TYPE_STRING) {
//            return parser.getAttributeValue(index);
//        }
//        if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
//            return String.format("#%08X", data);
//        }
//        if (type >= TypedValue.TYPE_FIRST_INT && type <= TypedValue.TYPE_LAST_INT) {
//            return String.valueOf(data);
//        }
//        return String.format("<0x%X, type 0x%02X>", data, type);
//    }
//
//    private static String getPackage(int id) {
//        if (id >>> 24 == 1) {
//            return "android:";
//        }
//        return "";
//    }
//
//    public static float complexToFloat(int complex) {
//        return (float) (complex & 0xFFFFFF00) * RADIX_MULTS[(complex >> 4) & 3];
//    }
//
//    private static final float RADIX_MULTS[] = {
//            0.00390625F,3.051758E-005F,1.192093E-007F,4.656613E-010F
//    };
//
//    private static final String DIMENSION_UNITS[] = {
//            "px","dip","sp","pt","in","mm","",""
//    };
//
//    private static final String FRACTION_UNITS[] = {
//            "%","%p","","","","","",""
//    };
//
//
//    /**
//     * 添加要检查的list
//     */
//
//    private void addList(){
//        hashMap.put(LIST1,false);
//        hashMap.put(LIST2,false);
//        hashMap.put(LIST3,false);
//        hashMap.put(LIST4,false);
//        hashMap.put(LIST5,false);
//        hashMap.put(LIST6,false);
//        hashMap.put(LIST7,false);
//        hashMap.put(LIST8,false);
//        hashMap.put(LIST9,false);
//        hashMap.put(LIST10,false);
//        hashMap.put(LIST11,false);
//    }
//
//
//
//
//    /**
//     * 添加输出结果的textview
//     * @param isTrue
//     * @param content
//     */
//
//    public void addTextView(boolean isTrue,String content){
//        TextView textView=new TextView(MainActivity.this);
//
//        LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        vlp.setMargins(5,5,5,5);
//        if (isTrue){
//            textView.setTextColor(Color.parseColor("#00ff00"));
//        }else{
//            textView.setTextColor(Color.parseColor("#ff0000"));
//        }
//        if (content!=null&&!TextUtils.isEmpty(content)){
//            textView.setText(content);
//        }
//        textView.setTextSize(15);
//        textView.setLayoutParams(vlp);
//        linearLayoutContainer.addView(textView);
//    }
//
//    public void changeTextView(String content){
//        textView.setText(content);
//        hashMap.clear();
//    }
//
//
//    /**
//     * 检查每个项目是否都有
//     * @param s
//     */
//
//    private  void checkSetting(String s){
//        if (s!=null && !TextUtils.isEmpty(s)){
//            if (s.contains(LIST1)){
//                hashMap.put(LIST1,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//
//            if (s.contains(LIST2)){
//                hashMap.put(LIST2,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//
//            if (s.contains(LIST3)){
//                hashMap.put(LIST3,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//
//            if (s.contains(LIST4)){
//                hashMap.put(LIST4,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//
//            if (s.contains(LIST5)){
//                hashMap.put(LIST5,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置（如果是国内版本，必须添加这个权限）");
//            }
//
//            if (s.contains(LIST6)){
//                hashMap.put(LIST6,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//            if (s.contains(LIST7)){
//                hashMap.put(LIST7,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//            if (s.contains(LIST8)){
//                hashMap.put(LIST8,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//            if (s.contains(LIST9)){
//                hashMap.put(LIST9,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//            if (s.contains(LIST10)){
//                hashMap.put(LIST10,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置");
//            }
//            if (s.contains(LIST11)){
//                hashMap.put(LIST11,true);
//                sendMessage(MyHandler.MTG_UPDATE_TRUE,s+"  已配置，（如果集成的是激励视频和插屏视频，这条必须加）");
//            }
//        }
//    }
//
//
//
//
//
//
//
//    private void sendMessage(int flag,String content){
//        Message message=new Message();
//        message.what=flag;
//        message.obj=content;
//        myHandler.sendMessage(message);
//    }
//
//
//
//
//    private  void checkDEX() throws Exception{
//        String  apkPath=MainActivity.this.getPackageManager().getApplicationInfo("com.mintegral.sdk.demo", 0).sourceDir;
////        String dataDir=MainActivity.this.getPackageManager().getApplicationInfo("com.mintegral.sdk.demo", 0).dataDir;
////        String nativeLibraryDir=MainActivity.this.getPackageManager().getApplicationInfo("com.mintegral.sdk.demo", 0).nativeLibraryDir;
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        PathClassLoader cl = new PathClassLoader(
//                apkPath,
//                systemClassLoader);
////        Class<?> handler = Class.forName("com.mintegral.sdk.demo.AppwallActivity", true, cl);
//        Class clazz = cl.loadClass("com.mintegral.sdk.demo.AppwallActivity");
//        Object invoke = clazz.newInstance();
//    }
}









