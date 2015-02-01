package com.mathcoder.androidforpc.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by mathcoder on 1/02/15.
 */
public class screenUtil {
    private final String TAG = screenUtil.class.getSimpleName();
    public void screen(String path,View v)
    {
        View view = v.getRootView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        boolean isSuccess = false;
        if (null != bitmap)
        {
            try{

                FileOutputStream out = new FileOutputStream(path);
                bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
                isSuccess = true;
            }catch(FileNotFoundException e)
            {
                Log.i(TAG, "FileNotFoundException");
            }
            finally{
                if (isSuccess)
                {
                    Log.i(TAG,"保存成功:"+path);
                }
                else
                {
                    Log.i(TAG,"保存失败："+path);
                }
            }
        }
    }
}
