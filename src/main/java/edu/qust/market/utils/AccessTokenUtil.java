package edu.qust.market.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

public class AccessTokenUtil {
    public static String access_token = "";
    private static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa53604527bfbb0d2&secret=6ca1bfbd80f371371725966f73a31c61";

    public static void getAccess_token() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                String json = HttpUtil.sendGetRequest(url,new LinkedMultiValueMap<String, String>(),new HttpHeaders());
                JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
                access_token = (String) jsonObject.get("access_token");
            }
        };
        timer.schedule(task, 0, 1000 * 60 * 60 * 2);
    }
}
