package edu.qust.market.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.qust.market.bean.File_formExample;
import edu.qust.market.bean.Stuff;
import edu.qust.market.bean.StuffExample;
import edu.qust.market.bean.UserExample;
import edu.qust.market.framework.bean.WebModel;
import edu.qust.market.framework.message.Message;
import edu.qust.market.mapper.File_formMapper;
import edu.qust.market.mapper.StuffMapper;
import edu.qust.market.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuffService {

    @Autowired
    private StuffMapper stuffMapper;
    @Autowired
    private File_formMapper file_formMapper;
    @Autowired
    private UserMapper userMapper;

    //查询所有并封入图片1
    //2.20 和用户头像、昵称
    public void selectAll(WebModel webModel){
        StuffExample stuffExample = new StuffExample();
        stuffExample.setLimitStart(webModel.getLimitStart());
        stuffExample.setPageSize(webModel.getPs());
        stuffExample.setOrderByClause("`CREATE_TIME` DESC");
        int count = stuffMapper.countByExample(stuffExample);
        webModel.setTotalCount(count);
        List<Stuff> list = stuffMapper.selectByExample(stuffExample);
        List<JSONObject> newlist = new ArrayList<>();
        setStuffImg(list, newlist);
        webModel.setData(newlist);
    }



    public Stuff selectStuffById(Long id){
        return stuffMapper.selectByPrimaryKey(id);
    }

    public void getStuffByCategory(Long cid,WebModel webModel){
        StuffExample stuffExample = new StuffExample();
        StuffExample.Criteria sec = stuffExample.createCriteria();
        sec.andCateIdEqualTo(cid);
        stuffExample.setLimitStart(webModel.getLimitStart());
        stuffExample.setPageSize(webModel.getPs());
        int count = stuffMapper.countByExample(stuffExample);
        webModel.setTotalCount(count);
        List<Stuff> list = stuffMapper.selectByExample(stuffExample);
        List<JSONObject> newlist = new ArrayList<>();
        setStuffImg(list, newlist);
        webModel.setData(newlist);
    }

    //搜索商品
    public void searchByKeyWords(String keyWords,WebModel webModel){
        StuffExample stuffExample = new StuffExample();
        stuffExample.setLimitStart(webModel.getLimitStart());
        stuffExample.setPageSize(webModel.getPs());
        stuffExample.or().andStuffNameLike("%" + keyWords + "%");
        stuffExample.or().andStuffInfoLike("%" + keyWords + "%");
        int count = stuffMapper.countByExample(stuffExample);
        List<Stuff> list =  stuffMapper.selectByExample(stuffExample);
        webModel.setTotalCount(count);
        List<JSONObject> newlist = new ArrayList<>();
        setStuffImg(list, newlist);
        webModel.setData(newlist);
    }

    public void selectStuffByUid(long id,WebModel webModel){
        StuffExample stuffExample = new StuffExample();
        stuffExample.setLimitStart(webModel.getLimitStart());
        stuffExample.setPageSize(webModel.getPs());
        StuffExample.Criteria sec = stuffExample.createCriteria();
        sec.andUserIdEqualTo(id);
        int count = stuffMapper.countByExample(stuffExample);
        List<Stuff> list = stuffMapper.selectByExample(stuffExample);
        List<JSONObject> newlist = new ArrayList<>();
        setStuffImg(list, newlist);
        webModel.setTotalCount(count);
        webModel.setData(newlist);
    }

    public int insertStuff(Stuff stuff){
        return stuffMapper.insertSelective(stuff);
    }

    //向返回数据中添加图片
    public void setStuffImg(List<Stuff> list, List<JSONObject> newlist) {
        for(Stuff s : list) {
            File_formExample file_formExample = new File_formExample();
            File_formExample.Criteria fec = file_formExample.createCriteria();
            fec.andTableEqualTo("tb_stuff");
            fec.andTableIdEqualTo(s.getStuffId().intValue());
            JSONObject jo = (JSONObject) JSON.parse(JSONObject.toJSONString(s));
            jo.put("file", file_formMapper.selectByExample(file_formExample));
            UserExample userExample = new UserExample();
            UserExample.Criteria uec = userExample.createCriteria();
            uec.andIdEqualTo(s.getUserId().intValue());
            jo.put("userName",userMapper.selectByExample(userExample).get(0).getNickname());
            jo.put("avatarUrl",userMapper.selectByExample(userExample).get(0).getAvatarurl());
            newlist.add(jo);
        }
    }

    public int pageViewAdd (long stuffId){
        Stuff stuff = new Stuff();
        stuff.setStuffId(stuffId);
        int pageView = (int) getPageViewByStuffId(stuffId) + 1;
        stuff.setPageView(pageView);
        return stuffMapper.updateByPrimaryKeySelective(stuff);
    }

    public long getPageViewByStuffId(long stuffId){
        return stuffMapper.selectByPrimaryKey(stuffId).getPageView();
    }
}
