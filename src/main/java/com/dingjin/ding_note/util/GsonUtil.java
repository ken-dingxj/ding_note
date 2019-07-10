package com.dingjin.ding_note.util;

import com.google.gson.Gson;

/**
 * @author ding
 * 单例gson工具
 */
public class GsonUtil {
    private static  Gson gson = new Gson();
    private  GsonUtil(){};
    public static  Gson getGson() {
       return gson;
    }
}
