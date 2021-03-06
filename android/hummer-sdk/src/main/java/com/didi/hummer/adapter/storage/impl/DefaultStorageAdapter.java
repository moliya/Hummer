package com.didi.hummer.adapter.storage.impl;

import android.content.SharedPreferences;

import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.storage.IStorageAdapter;

/**
 * 默认存储适配器
 *
 * Created by XiaoFeng on 2019-12-24.
 */
public class DefaultStorageAdapter implements IStorageAdapter {

    private static final String SP_NAME = "HummerStorage";
    private SharedPreferences sp;

    public DefaultStorageAdapter() {
        sp = HummerSDK.appContext.getSharedPreferences(SP_NAME, 0);
    }

    @Override
    public void set(String key, Object value) {
        if (!(value instanceof String)) {
            return;
        }
        sp.edit().putString(key, (String) value).apply();
    }

    @Override
    public Object get(String key) {
        return sp.getString(key, "");
    }

    @Override
    public void remove(String key) {
        sp.edit().remove(key).apply();
    }

    @Override
    public boolean exist(String key) {
        return sp.contains(key);
    }
}
