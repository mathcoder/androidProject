package com.mathcoder.androidforpc.services;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import com.mathcoder.androidforpc.MyActivity;
import com.mathcoder.androidforpc.utils.screenUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by mathcoder on 1/02/15.
 */
public class ScreenService extends Service {
    screenUtil mScreen = new screenUtil();
    static View vv = null;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");


        do{
            String path = MyActivity.mContext.getExternalCacheDir().getPath()+ File.separatorChar+sdf.format(new Date())+".png";//路径

            mScreen.screen(path,vv);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(true);
    }
    public static void setView(View v)
    {
        vv = v;
    }
}
