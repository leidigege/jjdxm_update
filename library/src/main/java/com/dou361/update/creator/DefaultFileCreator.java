package com.dou361.update.creator;

import android.content.Context;

import com.dou361.update.UpdateConfig;

import java.io.File;

/**
 * @author Administrator
 */
public class DefaultFileCreator implements ApkFileCreator {
    @Override
    public File create(String versionName) {
        File cacheDir = getCacheDir();
        cacheDir.mkdirs();
        return new File(cacheDir,"update_v_" + versionName);
    }

    File getCacheDir() {
        Context context = UpdateConfig.getConfig().getContext();
        File cacheDir = context.getExternalCacheDir();
        if (cacheDir == null) {
            cacheDir = context.getCacheDir();
        }
        cacheDir = new File(cacheDir,"update");
        return cacheDir;
    }
}
