package edu.qust.market.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.qust.market.bean.*;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.mapper.DiscussMapper;
import edu.qust.market.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussService {

    @Autowired
    private DiscussMapper discussMapper;
    @Autowired
    private UserMapper userMapper;

    public int insertDiscuss(Discuss discuss){
        return discussMapper.insertSelective(discuss);
    }

    public void selectDiscussByStuffId(Long sid,WebModel webModel){
        DiscussExample discussExample = new DiscussExample();
        discussExample.setLimitStart(webModel.getLimitStart());
        discussExample.setPageSize(webModel.getPs());
        DiscussExample.Criteria dec = discussExample.createCriteria();
        dec.andStuffIdEqualTo(sid);
        int count = discussMapper.countByExample(discussExample);
        List<Discuss> list  = discussMapper.selectByExample(discussExample);
        List<JSONObject> data = setUserAvatar(list);
        webModel.setTotalCount(count);
        webModel.setData(data);
    }

    public void selectDiscussByUserId(Long uid, WebModel webModel){
        DiscussExample discussExample = new DiscussExample();
        discussExample.setLimitStart(webModel.getLimitStart());
        discussExample.setPageSize(webModel.getPs());
        DiscussExample.Criteria dec = discussExample.createCriteria();
        dec.andUserIdEqualTo(uid);
        int count = discussMapper.countByExample(discussExample);
        List<Discuss> data = discussMapper.selectByExample(discussExample);
        webModel.setTotalCount(count);
        webModel.setData(data);
    }

    public Discuss selectDiscussById(long id){
        return discussMapper.selectByPrimaryKey(id);
    }

    //向返回数据中添加图片
    public List<JSONObject> setUserAvatar(List<Discuss> list) {
        List<JSONObject> newlist = new ArrayList<>();
        for(Discuss d : list){
            UserExample userExample = new UserExample();
            UserExample.Criteria uec = userExample.createCriteria();
            uec.andIdEqualTo(d.getUserId().intValue());
            JSONObject jo = (JSONObject) JSON.parse(JSONObject.toJSONString(d));
            jo.put("avatar_url",userMapper.selectByExample(userExample).get(0).getAvatarurl());
            jo.put("user_name",userMapper.selectByExample(userExample).get(0).getNickname());
            newlist.add(jo);
        }
        return newlist;
    }

    public List<JSONObject> selectDiscussByDiscussId(long discussId){
        ArrayList<Discuss> list = new ArrayList<>();
        Discuss discuss = discussMapper.selectByPrimaryKey(discussId);
        list.add(discuss);
        return setUserAvatar(list);
    }

}
