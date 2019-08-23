package edu.qust.market.controller;

import com.alibaba.fastjson.JSONObject;
import edu.qust.market.bean.Collection;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.ErrorEnum;
import edu.qust.market.framework.message.Message;
import edu.qust.market.service.CollectionService;
import edu.qust.market.service.SessionService;
import edu.qust.market.service.StuffService;
import edu.qust.market.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionComtroller {

    @Autowired
    private CollectionService collectionService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private StuffService stuffService;

    @RequestMapping("/selectUserCollection")
    public Message selectUserCollection(String token){
        try{
            String opedId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(opedId).get(0).getId();
            List<Collection> list = collectionService.selctCollectionByUid(id);
            JSONObject jo = new JSONObject();
            for(Collection collection : list){
                long gid = collection.getGid();
                jo.put("data",stuffService.selectStuffById(gid));
            }
            return Message.createSuccessMessage(jo);
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/addUserCollection")
    public Message addUserCollection(@RequestParam("token") String token,@RequestParam("gid") int gid){
        try{
            String opedId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(opedId).get(0).getId();
            Collection collection = new Collection();
            collection.setGid(gid);
            collection.setUid(id);
            collectionService.addCollection(collection);
            return Message.createSuccessMessage();
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/deleteUserCollection")
    public Message deleteUserCollection(@RequestParam("token") String token,@RequestParam("gid") int gid){
        try{
            String opedId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(opedId).get(0).getId();
            collectionService.delecrCollection(id,gid);
            return Message.createSuccessMessage();
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }

    @RequestMapping("/selectUserCollectionIf")
    public Message selectUserCollectionIf(@RequestParam("token") String token,@RequestParam("gid") int gid){
        try{
            String opedId = sessionService.selectSessionByToken(token).get(0).getId();
            int id = userService.selectIdByOpenId(opedId).get(0).getId();
            if(collectionService.countCollection(id,gid) >= 1){
                return Message.createSuccessMessage();
            }else {
                return Message.createFailureMessage(ErrorEnum.UnknowError);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Message.createFailureMessage(ErrorEnum.UnknowError);
        }
    }
}
