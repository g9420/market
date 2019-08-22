package edu.qust.market.utils;

import com.alibaba.fastjson.JSONObject;

public class ZylToken {
    private static String key = "zyl";
    private static Object ob = new Object();

    public static JSONObject addKey(long id){
        JSONObject jsonObject = new JSONObject();
        String new_key = key + id;
        String md5 = Md5Util.md5calc(new_key,ob);
        jsonObject.put("data",id);
        jsonObject.put("encode",md5);
        return jsonObject;
    }

    public static boolean portKey(long id,String encode){
        if (encode.equals(addKey(id).get("encode"))){
            return true;
        }
            return false;
    }

}
