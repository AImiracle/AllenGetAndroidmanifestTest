# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontpreverify
-dontskipnonpubliclibraryclassmembers
-dontusemixedcaseclassnames #不使用大小写的混淆，Linux系统对大小写敏感。
-optimizationpasses 5

-dontusemixedcaseclassnames          #混淆时不使用大小写混合类名
-dontskipnonpubliclibraryclasses     #不跳过library中的非public的类
-verbose                             #打印混淆的详细信息
-dontoptimize                        #不进行优化，建议使用此选项，
-dontpreverify                       #不进行预校验,Android不需要,可加快混淆速度。
-ignorewarnings                      #忽略警告

-optimizations !code/simplification/arithmetic,!field/*
-dontwarn android.**
-dontwarn android.support.v4.**
-dontwarn com.data.carrier.**
-dontwarn com.mintegral.**

#v4包不混淆
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**

-keep public class com.mintegral.allenliu.checkTool.CommonUtil {
    public <fields>;
    public <methods>;
}