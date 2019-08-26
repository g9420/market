package edu.qust.market.controller;

import edu.qust.market.bean.Discuss;
import edu.qust.market.bean.News;
import edu.qust.market.bean.Stuff;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/discuss")
@RestController
public class DiscussController {

    @Autowired
    private DiscussService discussService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private StuffService stuffService;

    @RequestMapping("/getDiscussByStuffId")
    public Message getDiscussByStuffId(@RequestParam("sid") Long sid, WebModel webModel){
        try{
            discussService.selectDiscussByStuffId(sid,webModel);
            return Message.createSuccessMessage(webModel);
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/getDiscussByUserId")
    public Message getDiscussByUserId(@RequestParam("token") String token, WebModel webModel){
        try{
            String openid = sessionService.selectSessionByToken(token).get(0).getId();
            long id = userService.selectIdByOpenId(openid).get(0).getId();
            discussService.selectDiscussByUserId(id,webModel);
            return Message.createSuccessMessage(webModel);
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/addDiscuss")
    public Message addDiscuss(@RequestParam("token") String token,Discuss discuss){
        try{
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            long id = userService.selectIdByOpenId(openId).get(0).getId();
            discuss.setUserId(id);
            discuss.setDiscussTime(System.currentTimeMillis());
            discussService.insertDiscuss(discuss);
            Long reUid;
            News news = new News();
            if(discuss.getReceiveDiscussId()!= 0){
                news.setType(1);
                reUid = discussService.selectDiscussById(discuss.getReceiveDiscussId()).getUserId();
            }else{
                reUid = stuffService.selectStuffById(discuss.getStuffId()).getUserId();
            }
//            if(reUid == id){
//                return Message.createSuccessMessage();
//            }
            news.setDisscussId(discuss.getDiscussId().intValue());
            news.setUid(reUid.intValue());
            newsService.insertNews(news);
            return Message.createSuccessMessage();
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/getDiscussByDiscussId")
    public Message getDiscussByDiscussId(@RequestParam("discussId") Long discussId){
        try{
            return Message.createSuccessMessage(discussService.selectDiscussByDiscussId(discussId));
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

}
