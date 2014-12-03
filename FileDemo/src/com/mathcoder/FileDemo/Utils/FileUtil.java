package com.mathcoder.FileDemo.Utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Function:文件操作类
 * Author: MathBoy
 * Date: 14-12-2.
 */
public class FileUtil {
    private final String TAG = "FileUtil:";
    public static final int PATH_DATA_DATA_PACKBAGE_CACHE = 1;
    public static final int PATH_SDCARD_ANDROID_PACKBAGE_CACHE = 2;

    private Context mContext;
    public FileUtil(Context context)
    {
        mContext = context;
    }
    public String getTargetPath(int path)
    {
        //http://www.2cto.com/kf/201304/203721.html,各种存储目录
        switch(path)
        {
            case PATH_DATA_DATA_PACKBAGE_CACHE:
                return mContext.getCacheDir().getPath();
            //注意权限哦。
            case PATH_SDCARD_ANDROID_PACKBAGE_CACHE:
                return mContext.getExternalCacheDir().getPath();
            default :
                return null;
        }
    }

    /**
     * 保存指定内容到指定路径。
     * ，不能保证不乱码。
     * @param filePath 指定的路径，可以通过getTargetPath方法获取，其中int参数，本类提供了静态常量。
     * @param filename 文件名含拓展名。
     * @param content 保存的内容。
     */
    public void saveFile(String filePath, String filename, String content)
    {
        try
        {
            Log.i(TAG,"保存路径："+filePath+"/"+filename);
            File f = new File(filePath,filename);
            FileOutputStream fout = new FileOutputStream(f);
//            FileOutputStream fout = mContext.openFileOutput(filename,Context.MODE_PRIVATE+Context.MODE_W);
//            OutputStreamWriter out=new OutputStreamWriter(fout,"utf-8");//指定编码
//            out.write(content);
//            out.close();
            fout.write(content.getBytes());
            fout.close();
            Log.i(TAG,"保存内容至SD卡成功");
        }catch(Exception e)
        {
            Log.i(TAG, "保存内容至SD卡失败");
        }
    }
}
