package com.mathcoder.androidforpc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.mathcoder.androidforpc.services.ScreenService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyActivity extends Activity {
    private final String TAG = MyActivity.class.getSimpleName();
    Button btnStart = null;//启动截图
    public static Context mContext = null;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }
    private void init()
    {
        mContext = this;
        btnStart = (Button)this.findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenService.setView(v);
                Intent intent = new Intent("com.mathcoder.ScreenService");
                startService(intent);
            }
        });
    }
}
