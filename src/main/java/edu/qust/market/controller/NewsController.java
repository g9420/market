package edu.qust.market.controller;

import edu.qust.market.bean.Discuss;
import edu.qust.market.bean.News;
import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.User;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussService discussService;
    @Autowired
    private StuffService stuffService;

    @RequestMapping("/selectNewsByToken")
    public Message selectNews(@RequestParam("token") String token, @RequestParam("sp") int sp) {
        try {
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            int uid = userService.selectIdByOpenId(openId).get(0).getId();
            WebModel webModel = new WebModel();
            webModel.setSp(sp);
            newsService.selectNewsByUid(uid, webModel);
            List<News> list = webModel.getData();
            List<HashMap<String, Object>> data = new ArrayList<>();
            for (News news : list) {
                HashMap<String, Object> map = new HashMap();
                Discuss discuss = discussService.selectDiscussById(Long.valueOf(news.getDisscussId()));
                User user = userService.selectUserById(discuss.getUserId().intValue());
                Stuff stuff = stuffService.selectStuffById(discuss.getStuffId());
                map.put("news", news);
                map.put("discuss", discuss);
                map.put("stuffId", stuff.getStuffId());
                if(news.getType()==1){
                    Discuss discuss_s = discussService.selectDiscussById(discuss.getReceiveDiscussId());
                    map.put("user", user.getNickname() + "回复了你的评论：" + discuss_s.getDiscussDesc());
                }else {
                    map.put("user", user.getNickname() + "回复了你发布的：" + stuff.getStuffName());
                }
                data.add(map);
            }
            return Message.createSuccessMessage(data);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/selectNewsNumberByToken")
    public Message selecrNewsNumber(@RequestParam("token") String token) {
        try {
            String openId = "";
            if(sessionService.selectSessionByToken(token).size() == 0){
                return Message.createFailureMessage(ErrorEnum.UnknownAccount);
            }
            openId = sessionService.selectSessionByToken(token).get(0).getId();
            int uid = userService.selectIdByOpenId(openId).get(0).getId();
            int count = newsService.selectNewsByUid(uid);
            return Message.createSuccessMessage(count);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/readAllByToken")
    public Message readAllByToken(@RequestParam("token") String token) {
        try {
            String openId = sessionService.selectSessionByToken(token).get(0).getId();
            int uid = userService.selectIdByOpenId(openId).get(0).getId();
            newsService.readAllByUid(uid);
            return Message.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/readOneById")
    public Message readOneByToken(News news) {
        try {
            news.setActive(1);
            newsService.readOneByid(news);
            return Message.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }
}
