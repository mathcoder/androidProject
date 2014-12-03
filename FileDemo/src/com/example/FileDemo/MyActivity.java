package com.example.FileDemo;

import Utils.FileUtil;
import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        FileUtil fHelper = new FileUtil(getApplicationContext());
        fHelper.saveFile(fHelper.getTargetPath(FileUtil.PATH_SDCARD_ANDROID_PACKBAGE_CACHE), "123.html", "<html>Hello World</html>");
        super.onWindowFocusChanged(hasFocus);
    }
}
