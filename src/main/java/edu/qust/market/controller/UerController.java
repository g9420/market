package edu.qust.market.controller;

import com.alibaba.fastjson.JSONObject;
import edu.qust.market.bean.Session;
import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.User;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.service.SessionService;
import edu.qust.market.service.StuffService;
import edu.qust.market.service.UserService;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UerController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private StuffService stuffService;

    @RequestMapping("/getUserStuff")
    public Message getUserStuff(@RequestParam("token") String token, WebModel webModel) {
        try {
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(openId).get(0).getId();
            stuffService.selectStuffByUid(id, webModel);
            return Message.createSuccessMessage(webModel);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/getUserAvatar")
    public Message getUserAvatar(@RequestParam("id") int id) {
        try {
            String url = userService.selectUserAvatarById(id);
            return Message.createSuccessMessage(url);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/updataUserStuff")
    public Message updataUserStuff(@RequestParam("token") String token, Stuff stuff) {
        try {
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(openId).get(0).getId();
            int uid = stuff.getUserId().intValue();
            if(id != uid){
                return Message.createFailureMessage(ErrorEnum.UnknowError);
            }
            userService.updataStuffByStuffId(stuff);
            return Message.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/getUserInfo")
    public Message getUSerInfo(@RequestParam("token") String token){
        try{
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            User user = userService.selectIdByOpenId(openId).get(0);
            return Message.createSuccessMessage(user);
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/updataUserInfo")
    public Message updataUserInfo(@RequestParam("openid") String openid,User user){
        try{
            System.out.println(user);
            int id = userService.selectIdByOpenId(openid).get(0).getId();
            user.setId(id);
            userService.updataUserById(user);
            return Message.createSuccessMessage();
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/selectUserLink")
    public Message selectUserLink(@RequestParam("token") String token,@RequestParam("uid") Integer userId){
        try{
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(openId).get(0).getId();
            User user = userService.selectUserById(userId);
            JSONObject jo = new JSONObject();
            if(user.getWechat()!=null&&!"".equals(user.getWechat())){
                jo.put("WeChat",user.getWechat());
            }
            if(user.getQq()!=null&&!"".equals(user.getQq())){
                jo.put("QQ",user.getQq());
            }
            if(user.getPhone()!=null&&!"".equals(user.getPhone())){
                jo.put("tel",user.getPhone());
            }
            return Message.createSuccessMessage(jo);
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

}
