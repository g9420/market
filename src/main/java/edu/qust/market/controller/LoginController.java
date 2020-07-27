package edu.qust.market.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.qust.market.bean.Session;
import edu.qust.market.bean.User;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.service.LoginService;
import edu.qust.market.service.SessionService;
import edu.qust.market.service.UserService;
import edu.qust.market.utils.AESDecryptUtil;
import edu.qust.market.utils.HttpUtil;
import edu.qust.market.utils.SHA1Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    String access_token = "";

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/dologin")
    public Message login(@RequestParam("code") String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=appid&secret=secret&js_code=" + code + "&grant_type=authorization_code";
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            String data = HttpUtil.sendGetRequest(url, params, new HttpHeaders());
            JSONObject jsonObject = (JSONObject) JSONObject.parse(data);
            String openid = (String) jsonObject.get("openid");
            String session_key = (String) jsonObject.get("session_key");
            String token = UUID.randomUUID().toString().replace("-", "");
            Session session = new Session();
            session.setSessionKey((String) jsonObject.get("session_key"));
            session.setId((String) jsonObject.get("openid"));
            session.setToken(token);
            if(sessionService.countSessionById(openid) >= 1){
                sessionService.upDataSession(session);
            }else{
                sessionService.insertSession(session);
            }
            return Message.createSuccessMessage(token);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }

    }

    @PostMapping(value = "/postUserInfo", produces = "application/json;charset=UTF-8")
    public Message postUserInfo(@RequestBody JSONObject jsonObject) {
        try {
            String userInfo = JSON.toJSONString(jsonObject.get("userInfo"));
            String signature = (String) jsonObject.get("signature");
            String iv = (String) jsonObject.get("iv");
            String encryptedData = JSON.toJSONString(jsonObject.get("encryptedData"));
            String token = (String) jsonObject.get("token");
            String session_key = sessionService.selectSessionByToken(token).get(0).getSessionKey();
            String signature2 = SHA1Util.encodePassword(userInfo + session_key);
            User user = JSONObject.parseObject(JSON.toJSONString(jsonObject.get("userInfo")), User.class);
            JSONObject jsonObject1 = JSONObject.parseObject(AESDecryptUtil.decrypt(encryptedData, session_key, iv));
            JSONObject jsonObject2 = JSONObject.parseObject(JSON.toJSONString(jsonObject1.get("watermark")));
            String openId = jsonObject1.get("openId").toString();
            String appid = jsonObject2.get("appid").toString();
            int timestamp = Integer.parseInt(jsonObject2.get("timestamp").toString());
            if (!signature.equals(signature2) || !loginService.timestamp(timestamp) || !appid.equals("wxa53604527bfbb0d2")) {
                return Message.createFailureMessage(ErrorEnum.UnknowError);
            }
            user.setOpenid(openId);
            System.out.println(user);
            if (userService.CountByOpenid(openId) > 0) {
                userService.updateUserByOpenid(user);
            } else {
                userService.insertUser(user);
            }
            return Message.createSuccessMessage("true");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }
}
